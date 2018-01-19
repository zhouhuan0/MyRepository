package com.yks.springboot_shiro.mapper;

import com.yks.springboot_shiro.pojo.User;

public interface UserMapper {
    public User findByUserName(String username);
}
