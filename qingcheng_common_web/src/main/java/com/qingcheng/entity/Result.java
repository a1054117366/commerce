package com.qingcheng.entity;

import java.io.Serializable;

/**
 * @author wxy
 * @date 2019/9/3
 * @time 9:12
 */
//实现Serializable为了让当前pojo能够在网络中传输
public class Result implements Serializable {
    private Integer code;//返回业务码  示例：0：成功  1：失败
    private String message;//信息
    private Object obj;//附带的信息

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
