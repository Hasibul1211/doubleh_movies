package com.doubleh.doubleh_movies.interceptor;


import com.doubleh.doubleh_movies.bean.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private Customer customer;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        customer=(Customer)request.getSession().getAttribute("customer");
        if(customer != null)
            return true;
        response.sendRedirect(request.getContextPath()+"/tologin");

        return false;
    }
}
