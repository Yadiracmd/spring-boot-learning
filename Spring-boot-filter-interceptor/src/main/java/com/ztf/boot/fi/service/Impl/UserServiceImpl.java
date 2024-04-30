package com.ztf.boot.fi.service.Impl;

import com.ztf.boot.fi.handler.ServerException;
import com.ztf.boot.fi.result.Result;
import com.ztf.boot.fi.service.UserService;
import com.ztf.boot.fi.utils.OssTemplate;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private OssTemplate ossTemplate;


    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".png", ".jpeg", ".gif", ".jpeg"};

    @Override
    public String updateUserAvatar(File file) {

        String returnImgUrl;
//        // 验证图片格式
//        boolean isLegal = false;
//        for (String type : IMAGE_TYPE) {
//            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
//                isLegal = true;
//                break;
//
//            }
//        }
//        if (!isLegal) {
//            // 图片格式不对抛出异常
//            throw new ServerException("图片格式不正确");
//        }


        String url = ossTemplate.ossUpload(file);
        return url;
    }
}
