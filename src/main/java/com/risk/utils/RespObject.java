package com.risk.utils;

/**
 * Created by xiaof on 2017/1/16.
 */

public class RespObject {
    /**请求成功*/
    public static final int SUCCESS = 200;
    public static final String SUCCESS_MSG = "请求成功！";

    private Integer code;
    private String msg;
    private Object data;

    public RespObject() {
    }

    public RespObject(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

