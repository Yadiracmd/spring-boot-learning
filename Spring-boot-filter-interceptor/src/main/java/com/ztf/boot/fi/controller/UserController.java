package com.ztf.boot.fi.controller;


import com.ztf.boot.fi.result.Result;
import com.ztf.boot.fi.service.UserService;
import com.ztf.boot.fi.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result<String> login(String username,String password){
        if("admin" .equals(username) && "123456" .equals(password)){
            String token = JwtUtil.createToken(1001, "admin");
            return Result.ok(token);
        }
        return Result.error("账号或密码错误");
    }


    // 更新头像
    @PostMapping("/updateAvatar")
    public void updateAvatar(@RequestBody MultipartFile file, HttpServletRequest request){
        // 获取文件
        String filePath = request.getAttribute("interceptData").toString();
        File file1 = new File(filePath);
        String resultUrl = userService.updateUserAvatar(file1);
        request.setAttribute("resultUrl",resultUrl);
    }

}
