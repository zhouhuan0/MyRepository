package com.yks.oms.user.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yks.oms.user.constant.StateCode;
import com.yks.oms.user.constant.StateInfo;
import com.yks.oms.user.entity.User;
import com.yks.oms.user.vo.LoginVO;
import org.apache.commons.lang3.StringUtils;

/**
 * 登录工具类
 *  @author zhouhuan 
 *  @version 1.0 
 *  @since JDK1.8
 *  @date 2018/2/5
 */
public class LoginUtil {
    /**
     * 解析登录sso返回的结果
     *
     * @param returnStr sso返回的结果
     * @return
     */
    public static LoginVO parseJsonStr(String returnStr) {
        LoginVO loginVO = new LoginVO();
        if (StringUtils.isNotBlank(returnStr)) {
            //将数据转换成json对象
            JSONObject jsonObject = JSON.parseObject(returnStr);
            //获取数据的状态码
            Integer stateCode = jsonObject.getInteger("state");
            //判断返回数据状态,根据状态返回结果
            if (StateCode.SUCCES.equals(stateCode)) {
                //200说明登录成功就获取权限
                loginVO = PermissionUtil.getUserPermission(jsonObject);
                //获取用户
                String user = jsonObject.getString("user");
                //获取用户名
                String name = jsonObject.getString("name");
                //获取用户昵称
                String nike = jsonObject.getString("nike");
                //获取用户票据
                String ticket = jsonObject.getString("ticket");
                loginVO.setState(stateCode);
                loginVO.setMsg(StateInfo.STATE_200.INFO);
                loginVO.setUser(user);
                loginVO.setName(name);
                loginVO.setNike(nike);
                loginVO.setTicket(ticket);
            } else {
                //其他状态
                //获取数据的响应信息
                String msg = jsonObject.getString("msg");
                loginVO.setState(stateCode);
                loginVO.setMsg(msg);
            }
        } else {
            loginVO.setState(StateCode.FAIL_500);
            loginVO.setMsg(StateInfo.STATE_500.INFO);
        }
        return loginVO;
    }

    /**
     * 判断用户信息是否完整
     * @param user 用户信息
     * @return
     */
    public static Boolean isMatch(User user){
        Boolean result = false;
        String userName = user.getUserName();
        String password = user.getPassword();
        if(StringUtils.isNotBlank(userName)&&StringUtils.isNotBlank(password)){
            result = true;
        }
        return result;
    }
}
