package com.doubleh.doubleh_movies.controller;

import com.doubleh.doubleh_movies.Service.MovieService;
import com.doubleh.doubleh_movies.bean.Cart;
import com.doubleh.doubleh_movies.bean.Customer;
import com.doubleh.doubleh_movies.bean.Movie;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MovieController {
    private int pageSize = 20;
    Movie movie=null;
    Cart cart=null;
    @Autowired
    private MovieService movieService;
    private List<Movie> movieList;


    @GetMapping("/index")
    public String index(){return "index";
    }
    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }
    @GetMapping("/movies")
    public String getMoviesByTitle(Model model, @RequestParam(defaultValue = "")
            String title){
        if(title!=null && title!="")
            title=title.toUpperCase();
        movieList=movieService.getFilmList(title);
        model.addAttribute("movieList",movieList);
        return "movie";
    }
    @GetMapping("/movies2")
    public String getMoviesByTitlePages(Model model, @RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "1") int page){
        if(title!=null && title!="")
            title=title.toUpperCase();
        if(page<1)
            page=1;
        PageHelper.startPage(page,pageSize);
        movieList=movieService.getFilmList(title);
        PageInfo<Movie> pageInfo=new PageInfo<Movie>(movieList);
        model.addAttribute("pageInfo",pageInfo);
        return "movie2bytitle";
    }
    @GetMapping("/moviesbycategory")
    public String getMoviesByCategory(int id,Model model){
        movieList=movieService.getMovieByCategory(id);
        model.addAttribute("movies",movieList);
        return "movie";
    }
    @GetMapping("/moviesbycategory2")
    public String getMoviesByCategoryPages(int id,Model
            model,@RequestParam(defaultValue = "1") int page){
        if(page<1)
            page=1;
        PageHelper.startPage(page,pageSize);
        movieList=movieService.getMovieByCategory(id);

        PageInfo<Movie> pageInfo=new PageInfo<Movie>(movieList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("categoryid",id);
        return "movie2bycategory";
    }

    @GetMapping("/detail")
    public String toDetail(int id,String category,Model model){
        movie = movieService.getMovieById(id);
        System.out.println(category+"===============");
        model.addAttribute("movie",movie);
        model.addAttribute("category",category);
        return "movie_detail2";
    }

    @RequestMapping("/addtocart")
    public String addToCart(int cid,int fid,String category,Model model){
        int result = 0;
        int quantity =1;
        System.out.println(category+"+++++++++++++++++++++++++++++++");
        String msg;
        Cart cart = movieService.getCartById(cid,fid);
        if(cart!=null){

            cart.setQuantity(cart.getQuantity()+1);
            result=movieService.updateCart(cart);
            if(result>0){
                System.out.println("Updated "+"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
            }else{
                System.out.println("No "+"ssssssssssssssssssssssssssssssss");
            }

            System.out.println("Already added");

            msg = "Already added to the cart";
            model.addAttribute("msg", msg);
            model.addAttribute("category",category);
            model.addAttribute("fid",fid);


        }else{
            System.out.println("inserted");
//            try {
                result = movieService.insertCart(cid,fid,quantity);
                model.addAttribute("category",category);
//            } catch (DataIntegrityViolationException e) {
//                System.out.println("history already exist");
//            }
            msg = "Added to cart successfully !";
            model.addAttribute("msg",msg);
            model.addAttribute("category",category);
            model.addAttribute("fid",fid);
        }




//        if (result>0){
//
//        }else {
//
//        }
        return "addcart_result";
    }


    // layout

    @GetMapping("/tohome")
    public String layout(){
        return "home";
    }
    @GetMapping("/toregister")
    public String toregister(){
        return "register";
    }

    @GetMapping("/home")
    public String getNewMovies(Model model){
        movieList=movieService.getNewMovies();
        model.addAttribute("movies",movieList);
        return "home";
    }

    @GetMapping("/todetails")
    public String todetails(){
        return "movie_detail2";
    }


//    @GetMapping("/cart")
//    public void toCart(int customer_id,Model model){
//        cart = movieService.getCartById(customer_id);
//        System.out.println(cart.getCustomer_id()+"+++++++++++++++++++++++++++");
//        System.out.println(cart.getMovieList());
//
//
//    }

    @RequestMapping("/cart")
    public String toCart(HttpServletRequest request,Model model){
        Customer customer=(Customer)request.getSession().getAttribute("customer");
        int customer_id = customer.getCustomer_id();
        movieList = movieService.getCartByCusId(customer_id);

        System.out.println(movieList+"ssssssssssssssssssssssssssssss");
        System.out.println(movieList.get(0).getSubtotal()+"LLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        model.addAttribute("movies_cart",movieList);

        return "cart";
    }
    @RequestMapping(value = "/quantity" )
    public String UpdateQuantity(int cid,int fid,int quantity){
        int result = 0;

//        System.out.println(category+"+++++++++++++++++++++++++++++++");
        String msg;
        Cart cart = movieService.getCartById(cid,fid);
        if(cart!=null) {

            cart.setQuantity(quantity);
            result = movieService.updateCart(cart);
            if (result > 0) {
                System.out.println("yesssssssssssssssssssssssssss");
            } else {
                System.out.println("Noooooooooooooooooooooooooooo");
            }
        }
        return "redirect:cart";
    }





}








