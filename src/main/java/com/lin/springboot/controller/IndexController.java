package com.lin.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class IndexController{
	
	@GetMapping(value="/index")
	public Map index(){
		Map map =new HashMap<>();
		map.put("我的名字","lin");
		map.put("我的性别","男");
		return map;
	}
	
	
	
}