package com.doubleh.doubleh_movies.mapper;


import com.doubleh.doubleh_movies.bean.Actor;
import com.doubleh.doubleh_movies.bean.Cart;
import com.doubleh.doubleh_movies.bean.Movie;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    @Select("select * from film f,film_list fl ,cart c where customer_id=#{customer_id} and f.film_id=c.film_id and fl.fid=c.film_id;")
    @Results({@Result(property = "fid",column = "film_id")})
    public List<Movie> getCartByCusId(int customer_id);


    @Select("select * from cart where customer_id=#{customer_id} and film_id=#{film_id}")
            public Cart getCartById(int customer_id,int film_id);

    @Update("update cart set quantity=#{quantity} where customer_id=#{customer_id} and film_id=#{film_id}")
            int updateCart(Cart cart);


    @Insert("insert into cart values(#{customer_id},#{film_id},#{quantity})")
    int insertCart(int customer_id, int film_id,int quantity);
//    @Insert("insert into cart values(#{customer_id},#{film_id},#{quantity})")
//    int insertCart(Cart cart);



}
