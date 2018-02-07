package com.yks.oms.user.vo;

/**
 * 基本的返回信息
 *  @author zhouhaun 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
public class ResultVo {
    /**
     * 业务状态
     */
    private Integer state;

    /**
     * 响应消息
     */
    private String msg;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                '}';
    }
}
