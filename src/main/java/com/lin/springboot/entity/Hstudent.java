package com.lin.springboot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生实体
 */
@Entity
@Table(name="student")
public class Hstudent implements Serializable{

    private static final long serialVersionUID = 2120869894112984147L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String sumScore;
    private String avgScore;
    private int age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSumScore() {
		return sumScore;
	}
	public void setSumScore(String sumScore) {
		this.sumScore = sumScore;
	}
	public String getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


}