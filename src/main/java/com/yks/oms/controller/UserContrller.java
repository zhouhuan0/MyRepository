package com.yks.oms.controller;

import com.yks.oms.Vo.ResultVo;
import com.yks.oms.service.UserService;
import com.yks.oms.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @author zhouhuan 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
@Controller
public class UserContrller {
    @Autowired
    private UserService userService;

    /**
     * 用户登录UI
     * @return
     */
    @RequestMapping("login")
    public String showLogin() {
        return "login";
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("userLogin")
    @ResponseBody
    public ResultVo login(@RequestParam String username, @RequestParam String password) {
        ResultVo resultVo = userService.login(username, password);
        return resultVo;
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping("userLogout")
    public String logout() {
        return "login";
    }
}
