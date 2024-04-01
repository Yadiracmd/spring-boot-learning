package com.ztf.boot.mp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ztf.boot.mp.entity.UserDO;
import com.ztf.boot.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    void insert(){
        UserDO userDO = new UserDO().setUsername("小米").setPhone("12345678901").setGender("女");

        int rs = userMapper.insert(userDO);
        System.out.println(rs);
        // 成功拿到回写的userId
        System.out.println(userDO.getId());
    }

    @Test
    void delete(){
        // 根据id删除
        // userMapper.deleteById(2);

        // 根据条件删除
        userMapper.delete(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, "小米"));
    }


    @Test
    void update(){
        // 1.根据id更新
        // userMapper.updateById(new UserDO().setId(3).setUsername("小猫").setPhone("12345678901"));
        // 2.LambadaQueryWrapper更新
        //userMapper.update(new UserDO().setUsername("张誉丹"),new LambdaQueryWrapper<UserDO>().eq(UserDO::getId,"3"));
        // 3.不创建对象
        userMapper.update(null,new LambdaUpdateWrapper<UserDO>()
                .set(UserDO::getUsername,"小猫")
                .set(UserDO::getPhone,"123456712201")
                .eq(UserDO::getId,"4")

        );
    }
}