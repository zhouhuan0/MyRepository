package com.yks.oms.user.vo;

/**
 * 日志信息
 *  @author zhouhuan
 *  @version 1.0 
 *  @see
 *  @since JDK1.8
 *  @date 2018年2月1日
 */
public class LogVO {
    /**
     * 日志参数
     */
    private String param;
    /**
     * 日志信息
     */
    private String message;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogVO{" +
                "param='" + param + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
