package com.ztf.spring.boot.chche.service.impl;

import com.ztf.spring.boot.chche.config.RedisCache;
import com.ztf.spring.boot.chche.config.RedisKeys;
import com.ztf.spring.boot.chche.exception.ErrorCode;
import com.ztf.spring.boot.chche.exception.ServerException;
import com.ztf.spring.boot.chche.service.AuthService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
@Slf4j

public class AuthServiceImpl implements AuthService {

    @Resource
    private RedisCache redisCache;

    @Override
    public String loginByPhone(String phone, String code) {
        // 获取验证码cachekey
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        // 从redis中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        // 效验验证码合法性
        if(ObjectUtils.isEmpty(redisCode) )
        {
            throw new ServerException(ErrorCode.SMS_CODE_EMPTY);
        }else if (!redisCode.toString().equals(code)){
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        redisCache.delete(smsCacheKey);
        // 返回token
        return UUID.randomUUID().toString();
    }
}