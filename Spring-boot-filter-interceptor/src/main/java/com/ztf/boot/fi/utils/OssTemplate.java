package com.ztf.boot.fi.utils;



import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.ztf.boot.fi.config.OssConfig;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mqxu
 * @description OssTemplate
 **/
@Component
public class OssTemplate {
    @Resource
    private OssConfig ossConfig;

    /**
     * 上传文件
     *
     * @param file 文件参数
     * @return 上传后的 url
     */

    public String ossUpload(File file) {
        String endpoint = ossConfig.getEndpoint();
        String bucket = ossConfig.getBucket();
        String host = ossConfig.getHost();
        String ak = ossConfig.getAk();
        String secret = ossConfig.getSecret();

        // 创建 OSSClient 实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, ak, secret);
        // 上传文件存放的路径
        String uploadPath = file.getName();
        // 获取文件的字节输入流
        InputStream inputStream = null;
        try {
            inputStream  = new FileInputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        * 现在阿里云oss默认图片上传ContentType是img/jpg
        * */
        ObjectMetadata meta = new ObjectMetadata();
        meta.setCacheControl("image/jpg");
        // 调用 SDK 上传文件
        ossClient.putObject(bucket, uploadPath, inputStream,meta);
        // 关闭 ossClient
        ossClient.shutdown();
        // 返回上传文件的 url
        return host + "/" + uploadPath;
    }

}