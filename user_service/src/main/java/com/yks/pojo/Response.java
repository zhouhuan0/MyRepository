package com.yks.pojo;

public class Response {
    // 响应业务状态200成功,500失败
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;

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
    public Response(Integer status,String msg){
        this.status = status;
        this.msg = msg;
    }
    public Response(Integer status,String msg,Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String toString() {
        return "Response{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

