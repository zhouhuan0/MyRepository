package com.yks.controller;


import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import com.yks.pojo.User;
import com.yks.service.MoTanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoConteller {

    @MotanReferer(basicReferer = "basicRefererConfigBean")
    private MoTanService moTanService;
    @RequestMapping("/hello")
    public String hello() {
        return moTanService.hello();
    }
    @RequestMapping("/demo")
    public User demo() {
        return moTanService.demo();
    }
    @RequestMapping("/hello2/{name}")
    public User hello2(@PathVariable String name) {
        User user = moTanService.hello2(name);
        return user;
    }
}
