package com.ztf.boot.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztf.boot.mp.entity.UserDO;
import com.ztf.boot.mp.mapper.UserMapper;
import com.ztf.boot.mp.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
