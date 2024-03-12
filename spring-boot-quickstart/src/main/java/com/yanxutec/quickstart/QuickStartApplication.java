package com.yanxutec.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;


@Slf4j
@SpringBootApplication
@ServletComponentScan
public class QuickStartApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(QuickStartApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("启动成功");
        log.info("测试地址：http://localhost:{}",env.getProperty("server.port"));
        log.info("后台接口地址:http://localhost:{}/swagger-ui.html ",env.getProperty("server.port"));

    }


//    @GetMapping("hello")
//    public String getHello(){
//        return "hello world112";
//    }

}
