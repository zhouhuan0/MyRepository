package com.yks.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限
 */
public class Module implements Serializable {
    /**
     * 权限id
     */
    private Integer mid;
    /**
     * 权限名字
     */
    private String mname;
    /**
     * 权限属于哪些角色
     */
    private Set<Role> roles = new HashSet<Role>();

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }
}
