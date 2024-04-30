package com.ztf.login.template.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztf.login.template.config.RedisCache;
import com.ztf.login.template.config.RedisKeys;
import com.ztf.login.template.entity.User;
import com.ztf.login.template.entity.po.UserInfoPo;
import com.ztf.login.template.entity.vo.LoginInfo;
import com.ztf.login.template.exception.ErrorCode;
import com.ztf.login.template.exception.ServerException;
import com.ztf.login.template.mapper.UserMapper;
import com.ztf.login.template.result.Result;
import com.ztf.login.template.service.UserService;
import com.ztf.login.template.utils.OssTemplate;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private OssTemplate ossTemplate;


    @Resource
    private RedisCache redisCache;


    @Override
    public Result<UserInfoPo> login(LoginInfo user) {
        // 0. 检查验证码是否正确
        checkCodeCorrect(user.getPhone(),user.getCode());


        ///1、将页面提交的密码password进行md5加密处理
        String password = user.getPassword();
        password = SaSecureUtil.md5(password);

        //2、根据页面提交的手机号phone查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,user.getPhone());
        User user1 = userMapper.selectOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if(user1 == null){
            return Result.error("账号不存在");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if(!user1.getPassword().equals(password)){
            return Result.error("密码错误");
        }

        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if(user1.getStatus() == 0){
            return Result.error("你的账号已封禁，请联系管理员！");
        }

        // 如果登录成功，将员工ID存入session并 返回登录成功
        StpUtil.login(user1.getId());
        SaTokenInfo info = StpUtil.getTokenInfo();
        UserInfoPo loginDto = new UserInfoPo();
        loginDto.setToken(info.getTokenValue());
        BeanUtils.copyProperties(user1, loginDto);
        return Result.ok(loginDto,"登录成功！");
    }

    @Override
    public Result<String> register(User user) {
        String password = user.getPassword();
        password = SaSecureUtil.md5(password);
        user.setPassword(password);
        user.setAvatar("https://ztf-power.oss-cn-hangzhou.aliyuncs.com/images/default.jpg");
        userMapper.insert(user);
        return Result.ok(null,"注册成功！");
    }

    @Override
    public Result<String> updateUserInfo(User user) {
        Integer id = StpUtil.getLoginIdAsInt();
        user.setId(id);
        userMapper.updateById(user);
        return Result.ok(null,"更新成功！");
    }

    @Override
    public Result<String> updateUserPassword(User user) {
        Integer id = StpUtil.getLoginIdAsInt();
        user.setId(id);
        String password = user.getPassword();
        password = SaSecureUtil.md5(password);
        user.setPassword(password);
        return null;
    }

    @Override
    public Result<String> updateUserAvatar(MultipartFile multipartFile) {
        String url = ossTemplate.ossUpload(multipartFile);
        return Result.ok(url,"上传成功！");
    }

    @Override
    public Result<UserInfoPo> getUserInfo() {
        Integer id = StpUtil.getLoginIdAsInt();
        User user = userMapper.selectById(id);
        UserInfoPo userInfoPo = new UserInfoPo();
        BeanUtils.copyProperties(user,userInfoPo);
        return Result.ok(userInfoPo);
    }



    private void checkCodeCorrect(String phone, String code) {
        // 获取验证码cachekey
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        // 从redis中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        // 效验验证码合法性
        if(ObjectUtils.isEmpty(redisCode) )
        {
            throw new ServerException(ErrorCode.SMS_CODE_EMPTY);
        }else if (!redisCode.toString().equals(code)){
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        redisCache.delete(smsCacheKey);

    }

}
