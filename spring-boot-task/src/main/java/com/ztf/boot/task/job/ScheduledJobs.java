package com.ztf.boot.task.job;


import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.ztf.boot.task.email.MailService;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class ScheduledJobs {

    @Resource
    private MailService mailService;

//    @Scheduled(fixedDelay = 3000)
//    public void fixedDelayJob() throws InterruptedException{
//        log.info("fixedRateJob start:{}",new Date());
//        log.info("fixedRateJob end:{}",new Date());
//    }
//
//
//    @Scheduled(fixedRate = 4000)
//    public void fixedRateJob() throws InterruptedException{
//        log.info("fixedRateJob start:{}",new Date());
//        log.info("fixedRateJob end:{}",new Date());
//    }

//    @Scheduled(cron = "0 7 16 6 5 *")
//    public void cronJob(){
//        log.info("生日快乐");
//    }

//    @Scheduled(fixedRate = 5000)
//    public void cronQrCode(){
//        String filePath = "D:\\xposed\\";
//        String UUID_VALUE = filePath+ UUID.randomUUID().toString()+".jpg";
//        QrCodeUtil.generate(new Date().toString(), 300, 300, FileUtil.file(UUID_VALUE));
//    }

    /*
    * 每年发邮件
    * */
//    @Scheduled(cron = "0 16 20 6 5 *")
//    public void cronJob() throws MessagingException {
//        log.info("准备发送邮件...");
//        String content = """
//                <body>
//                    <h1>Happy Birthday!</h1>
//                    <img src="https://github.com/" alt="生日蛋糕">
//                    <p class="message">Wishing you all the happiness your holiday can hold!</p>
//                </body>
//                """;
//
//        mailService.sentHtmlMail("16422802@qq.com","生日祝福",content);
//        log.info("邮件发送完成");
//    }

}
