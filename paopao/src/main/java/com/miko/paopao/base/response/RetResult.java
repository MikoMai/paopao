package com.miko.paopao.base.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author miko
 */
public class RetResult<T> {
    public int code;

    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}