package com.yks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {
   /* @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/demo")
    private Object findAll(){
        Object forObject = restTemplate.getForObject("http://SERVICE-USER/listByPage", Object.class);
        return forObject;
    }*/


    @GetMapping("/demo01")
    public String demo(){
        System.out.println("我启动了");
        return "hello";
    }
}
