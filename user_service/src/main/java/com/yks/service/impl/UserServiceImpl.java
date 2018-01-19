package com.yks.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.mapper.UserMapper;
import com.yks.pojo.User;
import com.yks.redis.RedisService;
import com.yks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;


    //@CacheEvict(value = "userCache",key = "'user.listByPage'")
    public List<User> listByPage() {
        //redisService.setObj("aaa","你好");
        //redisService.delObj("bb4");
        /*try {
            List<User> listByPage =(List<User>)redisService.getObj("listByPage");
            if(listByPage!=null){
                return listByPage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        PageHelper.startPage(1,3);
        List<User> users = userMapper.selectByExample(null);
        PageInfo<User> pageInfo = new PageInfo<User>(users);


       /* try {
            redisService.setObj("listByPage",users);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return users;
    }

}
