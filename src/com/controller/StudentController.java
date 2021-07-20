package com.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.dao.IStudentDAO;
import com.pojo.Student;
import com.service.StudentService;

//添加注解使这个类成为控制器
@Controller
@RequestMapping(value = "/student")
public class StudentController {
	
	ServletContext sc = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		
    //获取WebApplicationContext对象，然后getBean获取代理对象
	WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
	public StudentService service=(StudentService)context.getBean("helloProxy");

	@RequestMapping(value = "/entry")
	public ModelAndView entry() {
		//返回/keshe/login.jsp视图
		ModelAndView mView = new ModelAndView();  
		mView.setViewName("login");
		return mView;
	}
	
	@RequestMapping(value = "/zhuce")
	public ModelAndView zhuce() {
		//返回/keshe/zhuce.jsp视图
		ModelAndView mView = new ModelAndView();  
		mView.setViewName("zhuce");
		return mView;
	}
	
	@RequestMapping(value = "/xiugai")
	public ModelAndView xiugai(HttpServletRequest request) {
		String user_id=request.getParameter("userid");
		//获取该用户id,通过该id通过代理对象的业务返回该用户的Student对象，然后把它保存到session对象，通过跳转到xiugai.jsp把参数传过去
		Student stu=service.query(user_id);
		request.getSession().setAttribute("sm", stu);
		ModelAndView mView = new ModelAndView();  
		mView.setViewName("xiugai");
		return mView;
	}
	
	@RequestMapping(value = "/dating")
	public ModelAndView dating() {
		//返回/keshe/show.jsp视图
		ModelAndView mView = new ModelAndView();  
		mView.setViewName("show");
		return mView;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="user")String user_id,@RequestParam(name="password")String password,@RequestParam(name="code")String code,HttpServletRequest request) {
		String id=user_id;
		String pass=password;
		Student student=service.login(id);
		//把student对象保存到session对象中
		request.getSession().setAttribute("key",student);
		ModelAndView mView = new ModelAndView();  
		if(student!=null) {
			if(student.getPassword().equals(pass)) {
				//判断request传来的code和在CodeController中session保存的code是否相等，相等则验证码正确，登录成功
				if(request.getSession().getAttribute("code").equals(code)){
				System.out.println("登录成功");
				mView.setViewName("show");
				return mView;
				}
				else {
				System.out.println("验证码错误");
				mView.setViewName("entry");
				return mView;
				}
			}
			else {
				System.out.println("密码错误");
				mView.setViewName("entry");
				return mView;
			}
		}
		else {
			System.out.println("用户不存在");
			mView.setViewName("entry");
			return mView;
		}
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register(@RequestParam(name="userid")String userid,@RequestParam(name="password")String password,@RequestParam(name="realname")String realname,@RequestParam(name="status")String status,@RequestParam(name="code")String code,HttpServletRequest request) {
		String id=userid;
		String pass=password;
		String real_name=realname;
		String sex=status;
		Student student=new Student();
		student.setPassword(pass);
		student.setReal_name(real_name);
		student.setSex(sex);
		student.setUser_id(id);
		ModelAndView mView = new ModelAndView();  
		//判断request传来的code和在CodeController中session保存的code是否相等，相等则验证码正确，注册成功
		if(request.getSession().getAttribute("code").equals(code)){
		service.regester(student);
		mView.setViewName("login");
		System.out.println("注册成功");
		return mView;
		}
		else {
			System.out.println("验证码错误");
			mView.setViewName("zhuce");
			return mView;
		}
		
	}
	
	@RequestMapping(value = "/delete")
	public ModelAndView delete(@RequestParam(name="userid")String userid) {
		String id=userid;
		service.delete(id);
		ModelAndView mView = new ModelAndView();  
		mView.setViewName("show");
		return mView;
	}
	
	@RequestMapping(value = "/update")
	public ModelAndView update(@RequestParam(name="userid")String userid,@RequestParam(name="password")String password,@RequestParam(name="realname")String realname,@RequestParam(name="status")String status,@RequestParam(name="code")String code,HttpServletRequest request) {
		String id=userid;
		String pass=password;
		String real_name=realname;
		String sex=status;
		Student student=new Student();
		student.setPassword(pass);
		student.setReal_name(real_name);
		student.setSex(sex);
		student.setUser_id(id);
		ModelAndView mView = new ModelAndView();  
		if(request.getSession().getAttribute("code").equals(code)){
		service.update(student);
		mView.setViewName("show");
		return mView;
		}
		else {
			System.out.println("更新失败");
			mView.setViewName("show");
			return mView;
		}
	}
	
	@RequestMapping(value = "/show")
	public ModelAndView show(HttpServletRequest request) {
		//返回数据库springuser表中的所有记录，并把这些记录封装成List<Student>对象
		List<Student> list=service.showall();
		request.getSession().setAttribute("sl",list);
		ModelAndView mView = new ModelAndView();  
		mView.setViewName("show");
		return mView;
	}
}

