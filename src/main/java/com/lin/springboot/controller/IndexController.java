package com.lin.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lin.springboot.dao.IUserDao;
import com.lin.springboot.entity.Student;
import com.lin.springboot.mapper.StudentMapper;

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
	

	@Autowired
    private StudentMapper stuMapper;

    @RequestMapping("/likeName")
    public List<Student> likeName(@RequestParam String name){
        return stuMapper.likeName(name);
    }
	
    
    @Autowired
    IUserDao iUserDao;

    /**
     * 查询学生表数据
     * @return
     */
    @RequestMapping("/studentList")
    public List<Student> StudentList(){
        return iUserDao.getList();
    }
    

    /**
     * @param name 根据name 模糊查询
     * @return
     */
    @RequestMapping("/getStudentByName")
    public List<Student> getStudentByName(@RequestParam String name ){
        return iUserDao.findByName(name);
    }
	
}