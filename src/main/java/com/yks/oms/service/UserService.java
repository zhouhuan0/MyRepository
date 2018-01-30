package com.yks.oms.service;

import com.yks.oms.Vo.ResultVo;

/**
 *  @author zhouhuan 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
public interface UserService {
    public ResultVo login(String username, String password);
}
