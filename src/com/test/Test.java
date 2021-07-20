package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dao.IStudentDAO;
import com.pojo.Student;
import com.service.StudentService;


public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");
		StudentService service=(StudentService)context.getBean("helloProxy");
		//测试注册操作
		/*Student student=new Student();
		student.setUser_id("bnm123");
		student.setPassword("852123");
		student.setReal_name("班尼路");
		student.setSex("男");
		service.regester(student);*/

	}

}
