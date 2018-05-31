package com.lin.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.lin.springboot.entity.Student;


@Mapper

public interface IUserDao{

	@Select("select t.* from Student t where t.name like concat(concat('%',#{name}),'%')") 
	List<Student> findByName(@Param("name") String name);

	@Select("select t.* from Student t limit 10")
	List<Student> getList();
}
