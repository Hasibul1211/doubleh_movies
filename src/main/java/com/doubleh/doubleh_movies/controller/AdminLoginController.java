package com.doubleh.doubleh_movies.controller;


import com.doubleh.doubleh_movies.Service.AdminService;
import com.doubleh.doubleh_movies.Service.CustomerService;
import com.doubleh.doubleh_movies.bean.Admin;
import com.doubleh.doubleh_movies.bean.Customer;
import com.doubleh.doubleh_movies.bean.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes("admin")
public class AdminLoginController {
    private Admin admin;
    @Autowired
    private AdminService adminService;
    private List<Movie> allMovies;
//    @RequestMapping("/admin/login")
//    public String adminLogin(Model model){
//        String msg = "Hi Admin , ";
//        model.addAttribute("msg",msg);
//        return "admin/admin_login";
//    }


    @PostMapping("/admin/login")
    public String adminLogin(String admin_name,String admin_pwd, HttpServletRequest request, Model model){
//        customer = customerService.getCustomerById(customer.getCustomer_id(),customer.getPwd());

        admin = adminService.getAdmin(admin_name,admin_pwd);
        if (admin !=null){
            allMovies = adminService.getAllMovies();
            model.addAttribute("admin",admin);
            model.addAttribute("movies",allMovies);
            System.out.println(admin.getAdmin_name()+"aaaa");
//            request.getSession().setAttribute("customer",customer);
            return "admin/admin_panel";
        }else
            System.out.println("bbbbbbbbbb");
        return "admin/error2";


    }

    @GetMapping("/admin/tologin")
    public String toLogin(){
        return "admin/admin_login";
    }
//    @GetMapping("/admin/tomovie")
//    public String ss(){
//        System.out.println("u r hereeeeeeeeeeee");
//        return "redirect:admin/movie";
//    }
    @GetMapping("/admin/movie")
    public String getNewMovies(Model model){
        allMovies=adminService.getAllMovies();
        System.out.println("u r oooooooooooooooooooooooooooo");
        model.addAttribute("movies",allMovies);
        return "admin/admin_panel";
    }
}

