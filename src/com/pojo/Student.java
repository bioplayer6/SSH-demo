package com.pojo;

public class Student {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "user_id="+user_id+";real_name="+real_name+";password="+password+";sex="+sex;
	}
	private String user_id;
	private String real_name;
	private String password;
	private String sex;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
