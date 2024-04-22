package com.ztf.spring.boot.chche.controller;


import com.ztf.spring.boot.chche.result.Result;
import com.ztf.spring.boot.chche.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Result<String> login(@RequestParam String code, @RequestParam String phone){
        String token = authService.loginByPhone(phone,code);
        return Result.ok(token);

    }

}
