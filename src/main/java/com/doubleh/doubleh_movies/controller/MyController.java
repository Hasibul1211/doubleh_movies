package com.doubleh.doubleh_movies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/my")
//    @RequestMapping(value = "/my",method = RequestMethod.GET)
    public String my(){

        return "hello springboot!";
    }
}
