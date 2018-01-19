package com.yks.springboot_shiro.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable {
    private Integer rid;
    private String rname;
    private Set<User> users = new HashSet<User>();
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
