package com.doubleh.doubleh_movies.Service;


import com.doubleh.doubleh_movies.bean.Cart;
import com.doubleh.doubleh_movies.bean.Movie;
import com.doubleh.doubleh_movies.mapper.CartMapper;
import com.doubleh.doubleh_movies.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;


    @Autowired
    private CartMapper cartMapper;

    public List<Movie> getNewMovies(){
        return movieMapper.selectNewMovies();
    }
    public List<Movie> getFilmList(String title){
        return movieMapper.selectMovieList(title);
    }
    public List<Movie> getMovieByCategory(int category_id){
        return movieMapper.searchByCategory(category_id);
    }
    public Movie getMovieById(int id){
        return movieMapper.getMovieById(id);
    }

    public List<Movie> getByCustomer_id(int customer_id){
        return movieMapper.getByCustomer_id(customer_id);
    }

    public int insertCart(int customer_id,int film_id,int quantity){
        return cartMapper.insertCart(customer_id,film_id,quantity);
    }




//    public Cart getCartById(int customer_id){
//        return movieMapper.getCartById(customer_id);
//    }

    public List<Movie> getCartByCusId(int customer_id){
        return  cartMapper.getCartByCusId(customer_id);
    }

    public Cart getCartById(int customer_id, int film_id){
        return  cartMapper.getCartById(customer_id,film_id);
    }

    public int updateCart(Cart cart){
        return  cartMapper.updateCart(cart);
    }

}
