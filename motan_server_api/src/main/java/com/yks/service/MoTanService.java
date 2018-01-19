package com.yks.service;

import com.weibo.api.motan.transport.async.MotanAsync;
import com.yks.pojo.User;

@MotanAsync
public interface MoTanService {
    public String hello();
    public User demo ();
    public User hello2(String name);
}
