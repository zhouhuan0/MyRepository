package com.yks.oms.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @author zhouhuan 
 *  @version 1.0 
 *  @since JDK1.8
 *  @date 2018/2/5
 */
@Controller
public class Demo {
    @RequestMapping("api/oms/user/demo")
    @ResponseBody
    public String demo(){
        return "test";
    }
}
