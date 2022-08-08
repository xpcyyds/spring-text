package com.cdcompany.controller;

public class Result {

    private Integer data;
    private Integer code;

    public Result(Integer data) {
        this.data = data;
    }

    private String msg;

    public Result(Integer code, Integer data) {
        this.data = data;
        this.code = code;
    }

    /*public Result(Integer code) {
        this.code = code;
    }*/

    public Result() {
    }

    public Result(Integer code, Integer data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Integer data) {
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
}