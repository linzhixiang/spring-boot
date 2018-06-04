package com.lin.springboot.repository;

import java.util.List;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lin.springboot.entity.Student;

@Repository
@Table(name="Student")
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<Student, Integer > {

    public Student findOne(Integer id);

	public Student save(Student u);

    @Query("select t from Student t where t.name= :name")
    public List<Student> findUserByName(@Param("name") String name);
}