package com.ahuan.boot.config.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource(value = {"classpath:employee.properties"})
public class Employee {
    /**
     * 使用SpEl 读取 employee 的 names 属性，并分割为字符串集合
     * */

    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split(',')[0]}")
    private List<String> firstEmployeeName;

    @Value ("#{${employee.age}}")
    private Map<String, Integer> employeeAge;


    @Value ("#{${employee.age}.two}")
    private String employeeAgeTwo;

    @Value ("#{systemProperties['java.home']}")
    private String javaHome;

    @Value ("#{systemProperties['user.dir']}")
    private String userDir;
}
