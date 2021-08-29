package com.doubleh.doubleh_movies.controller;


import com.doubleh.doubleh_movies.Service.CustomerService;
import com.doubleh.doubleh_movies.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("customer")
public class LoginController {
    private Customer customer;
    @Autowired
    private CustomerService customerService;
    @PostMapping("/login")
    public String login(int customer_id,String pwd, HttpServletRequest request, Model model){
//        customer = customerService.getCustomerById(customer.getCustomer_id(),customer.getPwd());
        customer = customerService.getCustomerById(customer_id,pwd);
        if (customer !=null){
            model.addAttribute("customer",customer);
            System.out.println(customer.getCustomer_id()+"aaaa");
//            request.getSession().setAttribute("customer",customer);
            return "index2";
        }else
            System.out.println("bbbbbbbbbb");
            return "error";


    }

    @GetMapping("/tologin")
    public String toLogin(){
        return "login";
    }


    @GetMapping("/error")
    public String toError(){
        return "error";
    }

    @PostMapping("/addcustomer")
    public String addCustomer(int store_id, String first_name, String last_name,String email,String address_id,int active,String create_date,String lsat_update,String pwd,Model model) {
        int result = 0;
        String msg;
        System.out.println(first_name + "=========================");

        result = customerService.insertCustomer(store_id,first_name,last_name,email,address_id,active,create_date,lsat_update,pwd);
        if (result>0){
            msg ="welcome";
            model.addAttribute("msg",msg);
        }else {
            msg ="failed";
            model.addAttribute("msg",msg);
        }
//        try {
//            result =customerService.insertCustomer(store_id,first_name,last_name,email,address_id,active,create_date,lsat_update,pwd);
//        } catch (DataIntegrityViolationException e) {
//            System.out.println("history already exist");
//        }
//        if (result>0){
//            msg = "Welcome "+first_name;
//            model.addAttribute("msg",msg);
//        }else {
//            msg = "You are an old user !";
//            model.addAttribute("msg", msg);
//        }
        return "register_result";
//    }
    }
}

