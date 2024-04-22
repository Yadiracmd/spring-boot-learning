package com.ztf.spring.boot.chche.exception;

import com.ztf.spring.boot.chche.exception.ServerException;
import com.ztf.spring.boot.chche.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(value = ServerException.class)
    public Result<?> handleServerException(ServerException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> handleException(Exception e) {
        return Result.error(e.getMessage());
    }

}