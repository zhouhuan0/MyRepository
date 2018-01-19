package com.yks.pojo;

import java.io.Serializable;

/**
 * user对象
 */
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
