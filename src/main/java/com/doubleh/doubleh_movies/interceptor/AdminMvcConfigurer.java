package com.doubleh.doubleh_movies.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminMvcConfigurer implements WebMvcConfigurer {
    public AdminLoginInterceptor loginInterceptor(){
        return new AdminLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new AdminLoginInterceptor());
        registration.addPathPatterns("/admin/**");
        registration.excludePathPatterns(
                "/admin/tologin",
                "/admin/login",
                "/admin/error2.html",
                "/js/*.*",
                "/html/*.*",
                "/css/*.*",
                "/fonts/*.*",
                "/pictures/*.*"
        );




    }
}
