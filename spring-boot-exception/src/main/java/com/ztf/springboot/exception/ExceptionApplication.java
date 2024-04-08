package com.ztf.springboot.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ExceptionApplication {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ExceptionApplication.class);
        app.run(args);
    }
}
