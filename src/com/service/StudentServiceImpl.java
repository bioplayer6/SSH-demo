package com.service;

import java.util.List;

import com.dao.StudentDAO;
import com.pojo.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDAO dao;
	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	public void regester(Student stu) {
		// TODO Auto-generated method stub
		dao.insert(stu);
		System.out.println("注册成功");
	}

	@Override
	public List<Student> showall() {
		List<Student> list=dao.queryall();
		System.out.println("所有数据返回成功");
		return list;
	}

	@Override
	public Student login(String id) {
		Student student=dao.query(id);
		return student;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(Student stu) {
		// TODO Auto-generated method stub
		dao.update(stu);
		System.out.println("更新成功");
	}

	@Override
	public Student query(String id) {
		Student student=dao.query(id);
		return student;
	}

}
