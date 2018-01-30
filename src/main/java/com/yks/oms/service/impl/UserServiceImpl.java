package com.yks.oms.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yks.oms.Vo.ResultVo;
import com.yks.oms.constant.StateConstant;
import com.yks.oms.service.UserService;
import com.yks.oms.utils.HttpClientUtil;
import com.yks.oms.utils.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *  @author zhouhuan 
 *  @version 1.0 
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * SSO系统参数
     */
    @Value("${poseidon.third.sso.ticket_url}")
    private String ssoTicketUrl;
    @Value("${poseidon.third.sso.info_url}")
    private String ssoInfoUrl;
    @Value("${poseidon.third.sso.md5_salt}")
    private String md5Salt;
    @Value("${poseidon.third.sso.name}")
    private String sysName;

    /**
     * 从sso系统获取ticket
     * @return ticket
     */
    public String getTicketFromSSO() {
        //发送get请求票据
        String result = HttpClientUtil.doGet(ssoTicketUrl);
        //获取请求数据
        String substring = result.substring(result.indexOf("(") + 1, result.lastIndexOf(")"));
        //将数据转换成json对象
        JSONObject jsonObject = JSON.parseObject(substring);
        //判断获取票据是否成功,成功就返回票据,失败返回null
        if(StateConstant.HTTP_SUCCES.equals(jsonObject.getInteger("state"))){
            return jsonObject.getString("ticket");
        }else{
            return null;
        }
    }

    /**
     * 登录sso系统
     * @param username 用户名
     * @param password 用户密码
     * @param ticket 票据
     * @return
     */
    private String getInfoFromSSO(String username, String password, String ticket) {

        //拼接登录sso的url
        StringBuffer url = new StringBuffer(this.ssoInfoUrl);
        url.append("&user=" + username);
        url.append("&pwd=" + password);
        url.append("&ticket=" + ticket);

        // 需要加密的MD5字段，由请求的参数的值拼接而成
        String md5Str = "of_base_sso_apicheckdefault" + this.sysName + "1"
                + username + password + ticket + this.md5Salt;
        url.append("&md5=" + MD5Util.encode2hex(md5Str));
        //发送get请求
       return HttpClientUtil.doGet(url.toString());
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ResultVo login(String username, String password) {
        //获取票据
        String ticketFromSSO = getTicketFromSSO();
        System.out.println(ticketFromSSO);
        //登入sso系统验证
        String infoFromSSO = getInfoFromSSO(username, password, ticketFromSSO);
        //将数据转换成json对象
        JSONObject jsonObject = JSON.parseObject(infoFromSSO);

        //返回数据的状态码
        Integer state = jsonObject.getInteger("state");
        //判断返回数据状态,根据状态返回结果
        if(StateConstant.HTTP_SUCCES.equals(state)){
            List<String> userPermission = getUserPermission(jsonObject);
            return ResultVo.ok(userPermission);
        }else if(StateConstant.HTTP_FAIL_402.equals(state)){
            String msg = jsonObject.getString("msg");
            return ResultVo.build(state,msg);
        }else{
            return ResultVo.build(state,"系统故障");
        }
    }

    /**
     * 获取用户权限
     * @param ssoResultJson SSO返回的信息
     * @return List<String> 权限信息列表
     */
    private List<String> getUserPermission(JSONObject ssoResultJson) {
        // 权限信息封装在 allow 层中
        JSONObject allowRole = ssoResultJson.getJSONObject("role").getJSONObject("allow");
        List<String> userPermission = new ArrayList<>();

        // 有权限，则解析
        if (allowRole != null) {
            // 有数据的情况： pack里面是这样的  {里面有数据}
            // 无数据的情况： pack里面是这样的  [里面没数据]
            // 两种不同的数据类型，所以，只能这样判断到底有没数据
            String packString = allowRole.getString("pack");
            if (!(packString.indexOf("[]") == 0)) {
                JSONObject packJson = allowRole.getJSONObject("pack");

                // 有权限数据，则解析权限
                userPermission = getPermission(packJson);
            }
        }
        return userPermission;
    }

    /**
     * 获得用户的所有权限
     * @param packJson 权限所在的Json层
     * @return List<String> 权限信息列表
     */
    private List<String> getPermission(JSONObject packJson) {
        List<String> allPermission = new ArrayList<>();
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
}
