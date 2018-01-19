package com.yks.springboot_shiro.controller;

import com.yks.springboot_shiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DemoController {
    //@RequestMapping("/hello")
    @PutMapping("/hello")
    @RequiresPermissions("add")
    @ResponseBody
    public String showDemo(){
        //model.addAttribute("hello","hello world");
        return "demo";
    }
    @RequestMapping("/login2/{username}/{password}")
    public String login(@PathVariable String username,@PathVariable String password,HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken("zhouhuan","666");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user",user);
            return "index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
