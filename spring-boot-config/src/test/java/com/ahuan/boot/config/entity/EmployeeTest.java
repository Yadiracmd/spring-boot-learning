package com.ahuan.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeTest {
    @Resource
    private Employee employee;

    @Test
    void testEmployee(){
        System.out.println("雇员名称："+employee.getEmployeeNames());

    }
}