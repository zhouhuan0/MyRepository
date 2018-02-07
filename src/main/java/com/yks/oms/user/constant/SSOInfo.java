package com.yks.oms.user.constant;

/** sso相关信息
 *  @author zhouhuan 
 *  @version 1.0 
 *  @since JDK1.8
 *  @date 2018/2/5
 */
public class SSOInfo {
    /**
     * sso获取票据的url
     */
    public static final String SSO_TICKET_URL = "http://sso.youkeshu.com/?c=of_base_sso_api&a=ticket&callback=callback&name="+SSOInfo.SYS_NAME;
    /**
     *sso登录url
     */
    public static final String SSO_LOGIN_URL = "http://sso.youkeshu.com/?c=of_base_sso_api&a=check&space=default&name="+SSOInfo.SYS_NAME+"&role=1";
    /**
     *系统平台需要的md5盐
     */
    public static final String MD5_SALT = "123456";
    /**
     * 要获取权限的系统平台名称
     */
    public static final String SYS_NAME = "dingdan";
    /**
     *sso接口校验的字符串
     */
    public static final String SSO_API_CHECKD_EFAULT ="of_base_sso_apicheckdefault";
}
