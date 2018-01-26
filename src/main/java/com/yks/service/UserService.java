package com.yks.service;

import com.yks.mapper.UserMapper;
import com.yks.pojo.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
/**
 * 用户服务层
 */
public class UserService {
    @Autowired
    /**
     * 注入用户mapper
     */
    private UserMapper userMapper;

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 返回用户对象
     */
    public User findByUserName(String username) {
        System.out.println("执行了");
        return userMapper.findByUserName(username);
    }
}
