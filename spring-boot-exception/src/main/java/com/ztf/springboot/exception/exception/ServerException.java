package com.ztf.springboot.exception.exception;

import com.ztf.springboot.exception.enums.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;



@Data
@EqualsAndHashCode(callSuper = true)
public class ServerException extends RuntimeException{
    private final int code;
    private final String msg;

    public ServerException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }

    public ServerException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

}
