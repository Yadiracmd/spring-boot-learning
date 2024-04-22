package com.ztf.spring.boot.chche.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码枚举
 */
@Getter
@AllArgsConstructor // 全参构造器
public enum ErrorCode {
    UNAUTHORIZED(401, "登录失效，请重新登录"),
    INTERNAL_SERVER_ERROR(500, "服务器异常,请稍后重试"),
    UNKNOW_ERROR(999, "未知错误"),
    CODE_SEND_FAIL(3001, "短信发送失败"),
    SMS_CODE_ERROR(3002, "短信验证码错误"),
    PARAMS_ERROR(3003, "参数异常"),
    SMS_CODE_EMPTY(3004,"验证码失效");

    private final int code;

    private final String msg;


}
