package com.ahuan.boot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApplication.class);
        app.run(args);
    }
}
