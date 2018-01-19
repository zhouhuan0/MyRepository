package com.yks.controller;

import com.yks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSerciceInterface {
    @Autowired
    private UserService userService;

    @RequestMapping("/listByPage")
    public Object listByPage(){
        return userService.listByPage();
        //return "hello";
    }
}
