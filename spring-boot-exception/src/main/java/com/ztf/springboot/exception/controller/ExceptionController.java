package com.ztf.springboot.exception.controller;


import com.ztf.springboot.exception.service.MyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @Resource
    public MyService myService;

    @GetMapping("/user/{id}")
    public void getUser(@PathVariable("id") Integer id) {
        if(id == 1) {
            myService.unAuthorizedError();
        } else {
            myService.serverError();
        }
    }
}