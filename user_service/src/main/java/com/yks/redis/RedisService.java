package com.yks.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@EnableAutoConfiguration
public class RedisService  {
    @Autowired
    //private RedisTemplate<String, String> redisTemplate;
    private RedisTemplate redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations valOpsObj;

    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(String o){
        return valOpsObj.get(o);
    }

    /**
    * 设置obj缓存
    * @param o1
     * @param o2
     */
    public void setObj(String o1, Object o2) {
        valOpsObj.set(o1, o2);
    }

    /**
     * 删除Obj缓存
     *
     * @param o
     */
    public void delObj(String o) {
        redisTemplate.delete(o);
    }

}
