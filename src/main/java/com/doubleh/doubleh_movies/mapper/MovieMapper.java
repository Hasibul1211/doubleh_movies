package com.doubleh.doubleh_movies.mapper;


import com.doubleh.doubleh_movies.bean.Cart;
import com.doubleh.doubleh_movies.bean.Movie;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieMapper {
    @Select("select * from film_list where category='New' limit 12")
    public List<Movie> selectNewMovies();
    @Select("select * from film_list where title like concat('%',#{title},'%')")
    public List<Movie> selectMovieList(String title);


    @Select("select * from film f,film_category fc, category c where f.film_id=fc.film_id and c.category_id=fc.category_id and fc.category_id=#{category_id}")
    @Results({@Result(property = "fid", column = "film_id"),
            @Result(property = "category",column = "name")})
    public List<Movie> searchByCategory(int category_id);

    @Select("select * from film where film_id=#{fid}")
    @Results({@Result(property = "fid",column = "film_id"),
    @Result(property = "actors",column = "film_id"
    ,many = @Many(select = "com.doubleh.doubleh_movies.mapper.ActorMapper.getActorsByFilmId"))})
    Movie getMovieById(int id);

    @Select("select * from cart c,film f where customer_id=#{customer_id} and c.film_id=f.film_id")
    List<Movie> getByCustomer_id(int customer_id);




//    @Select("select * from cart where customer_id=#{customer_id}")
//    @Results({
//            @Result(property = "movieList",column = "film_id"
//                    ,many = @Many(select = "com.doubleh.doubleh_movies.mapper.CartMapper.getCartByCusId"))})
//    Cart getCartById(int id);
}
