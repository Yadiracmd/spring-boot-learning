package com.ztf.spring.boot.cache;


import com.ztf.spring.boot.chche.CacheApplication;
import com.ztf.spring.boot.chche.entity.Address;
import com.ztf.spring.boot.chche.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;


@SpringBootTest(classes = CacheApplication.class)
public class RedisTemplateTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Test
    void StringRedisTemplateTest(){
        stringRedisTemplate.opsForValue().set("hello","world",60, TimeUnit.SECONDS);
    }

    @Test
    void redisTemplateTest(){
        Address address = Address.builder().province("江苏").city("南京").build();
        User user = User.builder().name("ztf").id("111").address(address).build();
        redisTemplate.opsForValue().set("user",user,120,TimeUnit.SECONDS);
    }
}