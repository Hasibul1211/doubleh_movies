package com.doubleh.doubleh_movies.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/login",
                "/login.html",
                "/error",
                "/home.html",
                "/register.html",
                "/movie_detail2.html",
                "/toregister",
                "/todetails",
                "/register_result.html",
                "/addcustomer",
                "/layout_index",
                "/home",
                "/addcart_result.html",
                "/error.html",
                "/tologin",
                "/js/*.*",
                "/html/*.*",
                "/css/*.*",
                "/fonts/*.*",
                "/pictures/*.*",
                "/pictures/films/*.*",
                "/new_Movies"
        );




    }
}
