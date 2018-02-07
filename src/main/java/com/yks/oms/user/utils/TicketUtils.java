package com.yks.oms.user.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yks.oms.user.constant.StateCode;
import org.apache.commons.lang3.StringUtils;

/**
 * 票据工具类
 *  @author zhouhuan 
 *  @version 1.0 
 *  @since JDK1.8
 *  @date 2018/2/5
 */
public class TicketUtils {

    /***
     * 解析获取用户票据
     * @param returnStr sso返回的票据信息
     * @return 票据
     */
    public static String parseJsonStr(String returnStr) {
        String ticket = null;
        //判断sso返回信息
        if (StringUtils.isNotBlank(returnStr)) {
            //获取票据信息的json字符串
            String ticketJsonStr = returnStr.substring(returnStr.indexOf("(") + 1, returnStr.lastIndexOf(")"));
            //将数据转换成json对象
            JSONObject jsonObject = JSON.parseObject(ticketJsonStr);
            //通过状态码判断获取票据是否成功,成功就返回票据
            if (StateCode.SUCCES.equals(jsonObject.getInteger("state"))) {
                //获取票据
                ticket = jsonObject.getString("ticket");
            }
        }
        return ticket;
    }

}
