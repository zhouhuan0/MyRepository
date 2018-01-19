package com.yks.springboot_shiro.realm;

import com.yks.springboot_shiro.mapper.UserMapper;
import com.yks.springboot_shiro.pojo.Module;
import com.yks.springboot_shiro.pojo.Role;
import com.yks.springboot_shiro.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.getPrimaryPrincipal();
        Set<Role> roles = user.getRoles();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            info.addRole(role.getRname());
            for (Module module : (Set<Module>)role.getModules()) {
                info.addStringPermission(module.getMname());
            }
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        String username = utoken.getUsername();
        User user = userMapper.findByUserName(username);
        if(user!=null){
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
            return info;
        }
        return null;
    }
}

