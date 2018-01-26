package com.yks.controller;

import com.yks.pojo.User;
import com.yks.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DemoController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param username 用户名
     * @param password 用户密码
     * @param session
     * @return
     */
    @RequestMapping("/login2/{username}/{password}")
    public String login(@PathVariable String username,@PathVariable String password,HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
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

    /**
     * 退出登录
     * @param session 当前会话
     * @return 返回登录页面
     */
    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/demo")
    @ResponseBody
    @RequiresPermissions("kkk")
    public User demo() {
        return userService.findByUserName("zhouhuan");
        //return "index";
    }

}
