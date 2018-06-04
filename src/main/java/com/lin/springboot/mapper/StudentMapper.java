package com.lin.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.lin.springboot.entity.Student;

 
/**
 * @author lin
 * mybatis test
 *
 */
@Mapper
@Component(value = "StudentMapper") 

public interface StudentMapper {

    List<Student> likeName(String name);
    
    Student getById(int id);

    String getNameById(int id);

}