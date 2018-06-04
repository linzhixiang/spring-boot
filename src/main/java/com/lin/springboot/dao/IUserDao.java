package com.lin.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.lin.springboot.entity.Student;


@Mapper

public interface IUserDao{

	@Select("select t.* from Student t where t.name like concat(concat('%',#{name}),'%')") 
	List<Student> findByName(@Param("name") String name);

	@Select("select t.* from Student t limit 10")
	List<Student> getList();
	
	@Insert("Insert into Student(NAME,AGE) VALUES(#{0},#{1})")
	void insert(String name,int age);
	
	@Delete("Delete from Student where ID = #{id}")
	void delete(int id);
	
	@Update("update Student set age=#{0},name=#{1} where id= #{2}")
	void update(int age,String name,int id);
}
