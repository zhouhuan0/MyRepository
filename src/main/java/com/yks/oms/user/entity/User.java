package com.yks.oms.user.entity;

/**
 * 用户信息
 *  @author zhouhuan 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年2月1日
 */
public class User {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户的票据
     */
    private String ticket;


    public String getTicket() {
        return ticket;
    }


    public void setTicket(String ticket) {
        this.ticket = ticket;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
