package com.service;

import java.util.List;

import com.pojo.Student;

public interface StudentService {
	
	   //注册
	   public void regester(Student stu);
	  //展示所有数据
	  public List<Student> showall();
	  //登录
	  public Student login(String id);
	   //删除
	  public void delete(String id);
	   //更新
	  public void update(Student stu);
	   //查询单条数据
	  public Student query(String id);
}
