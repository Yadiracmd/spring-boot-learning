package com.ztf.springboot.exception.service;


import com.ztf.springboot.exception.enums.ErrorCode;
import com.ztf.springboot.exception.exception.ServerException;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void unAuthorizedError(){
        throw new ServerException(ErrorCode.UNAUTHORIZED);
    }

    /*
    * 模拟系统异常
    * */
    public void serverError() {
        throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
