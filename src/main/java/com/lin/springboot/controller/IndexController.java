package com.lin.springboot.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lin.springboot.dao.IUserDao;
import com.lin.springboot.entity.Student;
import com.lin.springboot.mapper.StudentMapper;
import com.lin.springboot.repository.UserRepository;

/**
 * @author lin
 *
 */
/**
 * @author lin
 *
 */
@Configuration
@RestController
public class IndexController{

	@Autowired
    private StudentMapper stuMapper;

    @Autowired
    IUserDao iUserDao;
    
    @Autowired
    private UserRepository userRepository;
    
    
	@GetMapping(value="/index")
	public Map index(){
		Map<Object, Object> map =new HashMap<>();
		map.put("我的名字","lin");
		map.put("我的性别","男");
		return map;
	}
	

    /**
     * @param name（mybatis）
     * @return
     */
    @RequestMapping("/likeName")
    public List<Student> likeName(@RequestParam String name){
        return stuMapper.likeName(name);
    }
	
    
    /**
     * 查询学生表数据（mybatis）
     * @return
     */
    @RequestMapping("/studentList")
    public List<Student> StudentList(){
        return iUserDao.getList();
    }
    
    
    /**
     * 插入数据
     * @param name
     * @param age
     * @return 
     * @throws Exception 
     */
	@RequestMapping("/insertData")
    public String insertData(@RequestParam String name,@RequestParam int age) throws Exception{
    	iUserDao.insert(name,age);
		return "插入成功";
    }
    
    
    /**
     * 根据id 删除某条数据
     * @param id
     * @return
     * @throws Exception
     */
	@RequestMapping("/deleteData")
    public String deleteData(@RequestParam int id) throws Exception{
    	iUserDao.delete(id);
		return "删除成功";
    }
    
    
	@RequestMapping("/updateData")
    public String updateData(@RequestParam int age,@RequestParam String name,@RequestParam int id) throws Exception{
    	iUserDao.update(age,name,id);
		return "修改成功";
    }

    /**
     * @param name 根据name 模糊查询（mybatis）
     * @return
     */
    @RequestMapping("/getStudentByName")
    public List<Student> getStudentByName(@RequestParam String name ){
    	//System.out.println(111);
        return iUserDao.findByName(name);
    }
	
    
   
    /**
     * @param id()
     * @return
     */
    @RequestMapping("/getStudentById")
    public Student getStudentByHibernate(@RequestParam Integer id ){
    	
        return userRepository.findOne(id);
    }
    
    /**
     * @param id()
     * @return
     */
    @RequestMapping("/findUserByName")
    public List<Student> findUserByName(@RequestParam String name ){
    	System.out.println("11111111xv1111111111vvvxxxx11222");
    	return userRepository.findUserByName(name);
    }
    
    /**
     * @param count数据
     * @return
     */
    @RequestMapping("/getCount")
    public long getCount( ){
        return userRepository.count();
    }
    
    /**hibanate 插入数据
     * 
     */
    @RequestMapping("/saveUser")
    public void saveUser() {
    	Student u = new Student();
        u.setName("wan");
        u.setAge(19);
        u.setAvgScore("98");
        u.setSumScore("333");
        userRepository.save(u);
    }
}