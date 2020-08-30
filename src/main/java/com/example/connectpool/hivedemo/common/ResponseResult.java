package com.example.connectpool.hivedemo.common;

public class ResponseResult {

    /**
     * 状态码.
     */
    private String code;
    /**
     * 返回信息.
     */
    private String msg;
    /**
     * 接口返回数据.
     */
    private Object data;


    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public ResponseResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }



    public static final ResponseResult success() {
        return new ResponseResult("1","success","");
    }

    public static final ResponseResult success(String msg,Object obj) {
        return new ResponseResult("1",msg,obj);
    }

    public static final ResponseResult success(Object obj) {
        return new ResponseResult("1","success",obj);
    }

    public static final ResponseResult error() {
        return new ResponseResult("0","","");
    }

    public static final ResponseResult error(Object obj) {
        return new ResponseResult("0","",obj);
    }


}
