package com.ztf.boot.mybatis.mapper;

import com.ztf.boot.mybatis.entity.Student;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class StudentMapperTest {

    @Resource
    private StudentMapper studentMapper;

    @Test
    void insert() {
        Student student = Student.builder().studentName("测试学生").hometown("江苏南京").clazzId(1).birthday(LocalDate.now()).build();
        int n = studentMapper.insert(student);
        assertEquals(1, n);

    }

    @Test
    void findStudentById() {
        Student student = studentMapper.findStudentById(8012);
        assertEquals("测试学生", student.getStudentName());
    }

    @Test
    void updateById() {
        Student student = Student.builder().studentId(8012).studentName("新的学生2").build();
        int n = studentMapper.updateById(student);
        assertEquals(1, n);
    }

    @Test
    void deleteById() {
        int n = studentMapper.deleteById(8012);
        assertEquals(1, n);
    }

    @Test
    void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .studentId(9000 + i)
                    .clazzId(1)
                    .studentName("测试学生" + i)
                    .hometown("江苏南京")
                    .birthday(LocalDate.now())
                    .build();
            students.add(student);
        }
        int n = studentMapper.batchInsert(students);
        assertEquals(10, n);
    }

    @Test
    void batchDelete() {
        List<Integer> idList = List.of(9000, 9001, 9002,9003);
        int n = studentMapper.batchDelete(idList);
        assertEquals(4, n);
    }

    @Test
    void selectByDynamicSql() {
        Student student = Student.builder().hometown("南京").build();
        List<Student> students = studentMapper.selectByDynamicSql(student);
        students.forEach(System.out::println);
    }

    @Test
    void batchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i = 4; i < 8; i++) {
            Student student = Student.builder()
                    .studentId(9000 + i)
                    .studentName("学生一" + i)
                    .build();

            if(i% 2 == 0){
                student.setHometown("江苏苏州");
            }
            students.add(student);
        }
        int n = studentMapper.batchUpdate(students);
        assertEquals(1, n);
    }

    @Test
    void getStudentManyToOne() {
        Student student = studentMapper.getStudentManyToOne(1001);
        log.info(String.valueOf(student));
    }

    @Test
    void getStudent() {
        Student student = studentMapper.getStudent(1001);
        log.info(String.valueOf(student));
    }
}