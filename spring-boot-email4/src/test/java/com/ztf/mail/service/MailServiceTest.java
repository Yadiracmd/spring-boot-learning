package com.ztf.mail.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceTest {

    @Resource
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("3570544406@qq.com","文字邮件","这是测试邮件");
    }

    @Test
    void sentHtmlMail() throws Exception{
        String content = """
                <body>
                    <img src="https://picx.zhimg.com/70/v2-ce68cb504edff9920486f30104863175_1440w.image?source=172ae18b&biz_tag=Post"/>
                </body>
                """;
        mailService.sentHtmlMail("3570544406@qq.com","html邮件",content);
    }

    @Test
    void sendAttachmentsMail() throws Exception{
        String filePath = "D:\\yadira.jks";
        mailService.sendAttachmentsMail("3570544406@qq.com","你好呀","这是测试邮件",filePath);
    }
}