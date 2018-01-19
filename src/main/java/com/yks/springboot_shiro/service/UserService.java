package com.yks.springboot_shiro.service;

import com.yks.springboot_shiro.mapper.UserMapper;
import com.yks.springboot_shiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findByUserName(String username){
        System.out.println("执行了");
        return userMapper.findByUserName(username);
    }
}
