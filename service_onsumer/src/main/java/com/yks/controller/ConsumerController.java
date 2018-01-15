package com.yks.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/add")
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String add(){
        return restTemplate.getForEntity("http://TEST-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallback(){
        return "服务器异常!!";
    }
}
