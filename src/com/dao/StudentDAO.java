package com.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.pojo.Student;

public class StudentDAO implements IStudentDAO {

	private HibernateTemplate template;                          //HibernateTemplate
	
	public void setTemplate(HibernateTemplate template) {       //setter注入
		this.template = template;
	}
	
	//插入一条数据
	 @Override
		public void insert(Student stu) {
	    	template.save(stu);
			System.out.println("插入数据成功");
		}

	 //查询单条数据
		@Override
		public Student query(String id) {
			Student student=template.get(Student.class, id);
			System.out.println("查询单条数据成功");
			return student;
		}

	  //删除一条数据
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Student stu=new Student();
		stu.setUser_id(id);
		template.delete(stu);
		System.out.println("删除数据成功");
	}

	//更新一条数据
	@Override
	public void update(Student stu) {
		// TODO Auto-generated method stub
		template.update(stu);
		System.out.println("更新数据成功");
	}

    //查询全部数据
	@Override
	public List<Student> queryall() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		List<Student> ls=(List<Student>)template.findByCriteria(criteria);
		System.out.println("查询全部数据成功");
		return ls;
	}

	

	
	
}
