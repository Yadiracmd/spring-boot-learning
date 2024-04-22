package com.ztf.spring.boot.chche.controller;

import com.ztf.spring.boot.chche.result.Result;
import com.ztf.spring.boot.chche.service.SmsService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Resource
    private SmsService smsService;

    @PostMapping("/send")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        smsService.sendSms(phone);
        return Result.ok();
    }
}
