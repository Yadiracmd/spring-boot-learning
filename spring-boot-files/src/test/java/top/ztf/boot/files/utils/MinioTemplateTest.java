package top.ztf.boot.files.utils;

import io.minio.ObjectWriteResponse;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * @Author DEZ
 * @Date 2024/4/15
 * @Description MinioTemplateTest
 */
@SpringBootTest
class MinioTemplateTest {

    @Resource
    private MinioTemplate minioTemplate;

    @Test
    void bucketExists() throws Exception {
        boolean flag = minioTemplate.bucketExists("dezckd");
        System.out.println(flag);
    }

    @Test
    void makeBucket() throws Exception {
        minioTemplate.makeBucket("dezckd");
    }

    @Test
    void putObject() throws Exception {
        File file = new File("D:\\Media\\Sticker\\EveOneCat\\twitter_Everyday One Cat(@motions_cat)_20200727-012200_1287558825105448961_gif.gif");

        ObjectWriteResponse owr = minioTemplate.putObject("dezckd", "img/" + UUID.randomUUID() + ".gif", new FileInputStream(file));
        System.out.println(minioTemplate.getEndPoint() + "/" + owr.object());
    }
}