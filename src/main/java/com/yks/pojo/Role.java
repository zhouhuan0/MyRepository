package com.yks.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 */
public class Role implements Serializable {
    /**
     * 角色id
     */
    private Integer rid;
    /**
     * 角色名字
     */
    private String rname;
    /**
     * 角色属于那些用户
     */
    private Set<User> users = new HashSet<User>();
    /**
     * 角色包含的权限
     */
    private Set<Module> modules = new HashSet<Module>();

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Set getUsers() {
        return users;
    }

    public void setUsers(Set users) {
        this.users = users;
    }

    public Set getModules() {
        return modules;
    }

    public void setModules(Set modules) {
        this.modules = modules;
    }
}
