package com.yks.oms.user.constant;

/**
 *  状态码信息
 *  @author zhouhuan
 *  @version 1.0
 *  @see
 *  @since JDK1.8
 *  @date 2018年2月1日
 */
public enum StateInfo {
    STATE_200("成功"),STATE_401("系统账号可能已停用"),STATE_402("帐号密码错误"),
    STATE_403(" 功能操作无效"),STATE_404("需先修改密码"),STATE_500("失败"),STATE_501("安全校验失败"),
    STATE_502("通信结构错误"),STATE_503("系统帐号操作权限不够"),STATE_504("票据失效");
    /**
     * 状态的信息
     */
    public final String INFO;

    private StateInfo(String info) {
        this.INFO = info;
    }

    public String getInfo() {
        return INFO;
    }
}

