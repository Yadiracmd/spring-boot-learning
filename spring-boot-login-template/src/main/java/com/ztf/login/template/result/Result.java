package com.ztf.login.template.result;



import com.ztf.login.template.enums.ErrorCode;
import lombok.Data;



@Data
public class Result<T> {
    private int code = 200;
    private String msg = "success";
    private T data;

    public static <T> Result<T> ok(String data) {
        return new Result<>();
    }


    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setMsg(msg);
        result.setCode(500);
        return result;
    }

    public static <T> Result<T> ok(T data,String msg) {
        Result<T> result = new Result<>();
        result.setData(data);
        result.setMsg(msg);
        return result;
    }


    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.setMsg(ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
        return result;
    }


    public static <T> Result<T> error(int code,String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}