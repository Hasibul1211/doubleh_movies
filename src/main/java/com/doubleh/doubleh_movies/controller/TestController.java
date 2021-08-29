package com.doubleh.doubleh_movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/test2")
    public String test2(Model model){
        model.addAttribute("msg","Hi there i am Hossam !");
        return "test";
    }
}
