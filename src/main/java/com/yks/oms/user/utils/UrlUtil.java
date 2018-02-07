package com.yks.oms.user.utils;

import com.yks.oms.user.constant.SSOInfo;
import com.yks.oms.user.entity.User;

/**
 * url工具类
 *  @author zhouhuan 
 *  @version 1.0 
 *  @since JDK1.8
 *  @date 2018/2/5
 */
public class UrlUtil {
    /**
     * 拼接url
     *
     * @param user 用户信息
     * @return
     */
    public static String getUrl(User user) {
        //拼接登录sso的url
        StringBuffer url = new StringBuffer(SSOInfo.SSO_LOGIN_URL);
        url.append("&user=" + user.getUserName());
        url.append("&pwd=" + user.getPassword());
        url.append("&ticket=" + user.getTicket());

        // 需要加密的MD5字段，由请求的参数的值拼接而成
        String md5Str = SSOInfo.SSO_API_CHECKD_EFAULT + SSOInfo.SYS_NAME + "1"
                + user.getUserName() + user.getPassword() + user.getTicket() + SSOInfo.MD5_SALT;
        url.append("&md5=" + MD5Util.encode2hex(md5Str));

        return url.toString();
    }
}
