package com.doubleh.doubleh_movies.interceptor;


import com.doubleh.doubleh_movies.bean.Admin;
import com.doubleh.doubleh_movies.bean.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    private Admin admin;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        admin=(Admin) request.getSession().getAttribute("admin");
        System.out.println(admin.getAdmin_name()+"  99999999999999999999999999999");
        if(admin != null)
            return true;
        response.sendRedirect(request.getContextPath()+"/admin/tologin");

        return false;
    }
}
