package com.ztf.login.template.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码枚举
 * */
@Getter
@AllArgsConstructor // 全参构造器
public enum ErrorCode {
    UNAUTHORIZED(401,"登录失效，请重新登录"),
    INTERNAL_SERVER_ERROR(500,"服务器异常,请稍后重试"),
    UNKNOW_ERROR(999,"未知错误");

    private final int code;

    private final String msg;


}
