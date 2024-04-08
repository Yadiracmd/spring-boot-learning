package com.ztf.springboot.exception.controller;

import com.ztf.springboot.exception.entity.User;
import com.ztf.springboot.exception.result.Result;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @PostMapping("/user/add")
    public Result<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult){
        // 校验未通过
        if (bindingResult.hasErrors()){
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }
}
