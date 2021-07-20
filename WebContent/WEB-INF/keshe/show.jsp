<%@page import="com.pojo.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background: url(${pageContext.request.contextPath }/images/keshe.jpg)">
<%
Student user=(Student)request.getSession().getAttribute("key");
String user_id=user.getUser_id();
 %>
<center>
<h1>欢迎你<%=user_id %></h1>
<h1>执行以下操作，管理用户</h1>
<form action="${pageContext.request.contextPath }/student/show.do">
<input type="submit" value="查询全部数据"/>
</form>
<br/>
<form action="${pageContext.request.contextPath }/student/entry.do">
<input type="submit" value="注销"/>
</form>
<%
if(request.getSession().getAttribute("sl")!=null){
	List<Student> list=(List<Student>)request.getSession().getAttribute("sl");
	int size=list.size();
%>
<table border="1">
<tr>
<td>用户id</td>
<td>真实姓名</td>
<td>密码</td>
<td>性别</td>
<td>删除</td>
<td>修改</td>
</tr>
<%
for(int i=0;i<size;i++){
	Student stu=list.get(i);
%>
<tr>
<td><%=stu.getUser_id() %></td>
<td><%=stu.getReal_name() %></td>
<td><%=stu.getPassword() %></td>
<td><%=stu.getSex() %></td>
<td><a href="${pageContext.request.contextPath }/student/delete.do?userid=<%=stu.getUser_id() %>">删除数据</a></td>
<td><a href="${pageContext.request.contextPath }/student/xiugai.do?userid=<%=stu.getUser_id() %>">个人信息修改</a></td>
</tr>
<%} %>
</table>
<%} %>
</center>
</body>
</html>