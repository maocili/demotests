package com.example.demotests.vo;

import java.io.Serializable;

public class JsonData implements Serializable {


    //状态码 0为成功 -1失败
    private int code;
    private Object data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public JsonData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }
}
