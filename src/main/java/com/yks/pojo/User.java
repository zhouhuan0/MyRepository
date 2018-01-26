package com.yks.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户拥有的角色
     */
    private Set<Role> roles = new HashSet<Role>();

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }
}
