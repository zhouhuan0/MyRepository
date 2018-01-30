package com.yks.oms.Vo;

/**
 *  @author zhouhaun 
 *  @version 1.0
 *  @see  
 *  @since JDK1.8
 *  @date 2018年1月30日
 */
public class ResultVo {
    /**
     *  响应业务状态
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;

    /**
     * 构建其他状态的ResultVo对象
     * @param status 状态
     * @param msg 消息
     * @param data 数据
     * @return
     */
    public static ResultVo build(Integer status, String msg, Object data) {
        return new ResultVo(status, msg, data);
    }

    public static ResultVo ok(Object data) {
        return new ResultVo(data);
    }

    public static ResultVo ok() {
        return new ResultVo(null);
    }

    public ResultVo() {

    }

    public static ResultVo build(Integer status, String msg) {
        return new ResultVo(status, msg, null);
    }

    public ResultVo(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultVo(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
