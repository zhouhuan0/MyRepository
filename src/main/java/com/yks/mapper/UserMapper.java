package com.yks.mapper;

import com.yks.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper
 */
@Mapper
public interface UserMapper {
    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 返回用户对象
     */
    public User findByUserName(String username);
}
