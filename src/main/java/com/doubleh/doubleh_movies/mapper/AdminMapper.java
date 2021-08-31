package com.doubleh.doubleh_movies.mapper;


import com.doubleh.doubleh_movies.bean.Admin;
import com.doubleh.doubleh_movies.bean.Customer;
import com.doubleh.doubleh_movies.bean.Movie;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    @Select("select * from admin where admin_name=#{admin_name} and admin_pwd=#{admin_pwd}")
    Admin getAdmin(String admin_name, String admin_pwd);

//    @Insert("insert into admin (admin_name,admin_pwd) values(#{admin_name},#{admin_pwd}")
//    int insertAdmin(String admin_name, String admin_pwd);
    @Select("select * from film_list")
    List<Movie> getAllMovies();
}
