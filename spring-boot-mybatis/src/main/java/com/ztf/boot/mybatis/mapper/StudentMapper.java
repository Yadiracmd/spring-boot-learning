package com.ztf.boot.mybatis.mapper;

import com.ztf.boot.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {


    /**
     * 插入一个学生
     * */
    int insert(Student student);


    /*
    * 通过id查找学生编号
    * */
    Student findStudentById(int studentId);

    /*
    * 通过id更新学生编号
    * */
    int updateById(Student student);

    /*
    * 通过id删除学生
    * */
    int deleteById(int studentId);


    /*
    * 批量插入
    * */
    int batchInsert(@Param("students")List<Student> students);


    /*
    * 批量删除
    * */
    int batchDelete(@Param("idList")List<Integer> ids);

    /*
    * 批量更新
    * */
    int batchUpdate(@Param("students")List<Student> students);


    /*
    * 动态传递参数
    * */
    List<Student> selectByDynamicSql(Student student);

    Student getStudentManyToOne(int studentId);


    /**
     * 根据学生id查询（关联查询出所属班级信息，所选课程信息）
     *
     * @param studentId 学生id
     * @return 学生对象
     */
    Student getStudent(int studentId);
}
