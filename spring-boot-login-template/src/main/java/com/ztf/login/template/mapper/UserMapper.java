package com.ztf.login.template.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztf.login.template.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}