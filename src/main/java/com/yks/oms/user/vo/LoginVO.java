package com.yks.oms.user.vo;

/**
 * 登陆返回信息
 *  @author zhouhuan 
 *  @version 1.0 
 *  @see  
 *  @since JDK1.8
 *  @date 2018年2月1日
 */
public class LoginVO extends ResultVo {
    /**
     * 用户id
     */
    private String user;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户昵称
     */
    private String nike;
    /**
     * 用户票据
     */
    private String ticket;
    /**
     * 是否是超级管理员 true/false
     */
    private Boolean isAdmin;

    /**
     * 拥有的权限
     */
    private Object func;


    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getNike() {
        return nike;
    }


    public void setNike(String nike) {
        this.nike = nike;
    }


    public String getTicket() {
        return ticket;
    }


    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    public Object getFunc() {
        return func;
    }


    public void setFunc(Object func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "state=" + getState() +
                ", msg='" + getMsg() + '\'' +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", nike='" + nike + '\'' +
                ", ticket='" + ticket + '\'' +
                ", isAdmin=" + isAdmin +
                ", func=" + func +
                '}';
    }
}
