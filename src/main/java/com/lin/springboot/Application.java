package com.lin.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

//@ComponentScan(basePackages={"com.lin.springboot"})
@MapperScan(value = {"com.lin.springboot.dao","com.lin.springboot.mapper"})
@EnableJpaRepositories(basePackages = "com.lin.springboot.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
