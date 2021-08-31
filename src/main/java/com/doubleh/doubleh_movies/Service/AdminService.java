package com.doubleh.doubleh_movies.Service;

import com.doubleh.doubleh_movies.bean.Admin;
import com.doubleh.doubleh_movies.bean.Movie;
import com.doubleh.doubleh_movies.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Admin getAdmin(String admin_name,String admin_pwd){
        return adminMapper.getAdmin(admin_name,admin_pwd);
    }

    public List<Movie> getAllMovies(){
        return adminMapper.getAllMovies();
    }

}
