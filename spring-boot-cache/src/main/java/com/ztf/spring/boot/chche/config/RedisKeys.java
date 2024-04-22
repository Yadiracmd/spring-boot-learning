package com.ztf.spring.boot.chche.config;


public class RedisKeys {
    public static String getSmsKey(String phone) {
        return "sms:cache:" + phone;
    }


}
