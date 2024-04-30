package com.ztf.login.template.config;


public class RedisKeys {
    public static String getSmsKey(String phone) {
        return "sms:cache:" + phone;
    }


}
