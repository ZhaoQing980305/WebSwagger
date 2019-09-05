package com.example.demo.webService.dao;

import com.example.demo.webService.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentDao {

    Student getStudentById(@Param("id") Integer id);
    Collection<Student> findAll();
    int deleteById(@Param("id") Integer id);
    int putStudent(Student student);
    int UpdateStudent(Student student);
}
