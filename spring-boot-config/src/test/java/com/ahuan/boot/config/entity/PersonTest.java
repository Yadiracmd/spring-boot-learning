package com.ahuan.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonTest {

    @Resource
    private Person person;

    @Resource
    private Dog dog;

    @Test
    void testPerson() {
        System.out.println(person);
        System.out.println(dog);
    }

}