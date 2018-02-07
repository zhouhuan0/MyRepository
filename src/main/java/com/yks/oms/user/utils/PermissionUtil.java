package com.yks.oms.user.utils;

import com.alibaba.fastjson.JSONObject;
import com.yks.oms.user.vo.LoginVO;

import java.util.*;

/**
 * 权限工具类
 *  @author zhouhuan 
 *  @version 1.0 
 *  @since JDK1.8
 *  @date 2018/2/5
 */
public class PermissionUtil {
    /**
     * 解析用户的所有权限
     *
     * @param packJson 权限所在的Json层
     * @return List<String> 权限信息列表
     */
    public static List<String> getPermission(JSONObject packJson) {
        List<String> allPermission = new ArrayList<String>();
        Iterator<Map.Entry<String, Object>> packIterator = packJson.entrySet().iterator();

        // 遍历用户所拥有的角色
        while (packIterator.hasNext()) {
            Map.Entry<String, Object> entry = packIterator.next();
            // 获取每个角色下面的权限
            JSONObject privilegeJson = packJson.getJSONObject(entry.getKey()).getJSONObject("func");
            Set<String> privilegeSet = privilegeJson.keySet();
            Iterator<String> privilegeIterator = privilegeSet.iterator();
            // 遍历该角色下面的所有权限
            while (privilegeIterator.hasNext()) {
                String privilege = privilegeIterator.next();
                if (!(allPermission.contains(privilege))) {
                    allPermission.add(privilege);
                }
            }
        }
        return allPermission;
    }

    /**
     * 获取用户权限
     *
     * @param ssoResultJson SSO返回的信息
     * @return
     */
    public static LoginVO getUserPermission(JSONObject ssoResultJson) {
        // 权限信息封装在 allow 层中
        JSONObject allowRole = ssoResultJson.getJSONObject("role").getJSONObject("allow");
        LoginVO loginVO = new LoginVO();
        List<String> userPermission = new ArrayList<String>();
        // 有权限，则解析
        if (allowRole != null) {
            // 有数据的情况： pack里面是这样的  {里面有数据}
            // 无数据的情况： pack里面是这样的  [里面没数据]
            // 两种不同的数据类型，所以，只能这样判断到底有没数据
            String packString = allowRole.getString("pack");
            if (!(packString.indexOf("[]") == 0)) {
                JSONObject packJson = allowRole.getJSONObject("pack");

                JSONObject admin = packJson.getJSONObject("admin");
                //判断是否为超级管理员
                if (admin != null) {
                    loginVO.setIsAdmin(true);
                } else {
                    loginVO.setIsAdmin(false);
                }
                // 有权限数据，则解析权限
                userPermission = getPermission(packJson);
            }
        }
        loginVO.setFunc(userPermission);
        return loginVO;
    }
}
