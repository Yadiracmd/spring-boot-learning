package com.ztf.login.template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ztf.login.template.entity.User;
import com.ztf.login.template.entity.po.UserInfoPo;
import com.ztf.login.template.entity.vo.LoginInfo;
import com.ztf.login.template.result.Result;
import org.springframework.web.multipart.MultipartFile;

public interface UserService extends IService<User> {


    /*
    * 登录
    * */
    Result<UserInfoPo> login(LoginInfo user);

    Result<String> register(User user);

    Result<String> updateUserInfo(User user);

    Result<String> updateUserPassword(User user);

    Result<String> updateUserAvatar(MultipartFile file);


    Result<UserInfoPo> getUserInfo();
}
