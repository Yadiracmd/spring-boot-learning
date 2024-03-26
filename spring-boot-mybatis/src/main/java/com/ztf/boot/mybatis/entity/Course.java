package com.ztf.boot.mybatis.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private Integer courseId;
    private String courseName;
    private List<Student> students;
}