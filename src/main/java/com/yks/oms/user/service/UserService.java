package com.yks.oms.user.service;


import com.yks.oms.user.entity.User;
        import com.yks.oms.user.vo.LoginVO;

/**
 *  @author zhouhuan 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param user 用户登录信息
     * @return
     */
    public LoginVO login(User user);
}
