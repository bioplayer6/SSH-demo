package com.dao;

import java.sql.Date;
import java.util.List;

import com.pojo.Student;

public interface IStudentDAO {

	//添加一条数据到数据库中
	  public void insert (Student stu);
	 //查询所有数据
	  public List<Student> queryall();
	  //查询单条数据
	  public Student query(String id);
	  //删除单条数据
	   public void delete(String id);
	  //修改一条数据
	   public void update(Student stu);

}
