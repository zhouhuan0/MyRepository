package com.yks.service.impl;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import com.yks.pojo.User;
import com.yks.service.MoTanService;

@MotanService
public class MoTanServiceImpl implements MoTanService {
    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public User demo() {
        User user = new User();
        user.setId(8888);
        user.setName("张三");
        return user;
    }

    @Override
    public User hello2(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }
}
