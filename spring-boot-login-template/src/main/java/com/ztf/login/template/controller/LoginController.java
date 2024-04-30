package com.ztf.login.template.controller;


import com.ztf.login.template.entity.User;
import com.ztf.login.template.entity.po.UserInfoPo;
import com.ztf.login.template.entity.vo.LoginInfo;
import com.ztf.login.template.result.Result;
import com.ztf.login.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/user")
public class LoginController {


    @Autowired
    private UserService userService;



    // 登录
    @PostMapping("/login")
    public Result<UserInfoPo> login(@RequestBody LoginInfo user){
        return userService.login(user);
    }

    // 注册
    @PostMapping("/register")
    public Result<String> register(@RequestBody User user){
        return userService.register(user);
    }

    // 更新用户信息
    @PostMapping("/update")
    public Result<String> updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    // 更新头像
    @PostMapping("/updateAvatar")
    public Result<String> updateAvatar(@RequestBody MultipartFile file){
        return userService.updateUserAvatar(file);
    }


    // 获取用户信息
    @GetMapping("/info")
    public Result<UserInfoPo> getUserInfo(){
        return userService.getUserInfo();
    }

}
