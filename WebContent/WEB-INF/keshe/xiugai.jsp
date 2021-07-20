<%@page import="com.pojo.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改界面</title>
</head>
<body style="background: url(${pageContext.request.contextPath }/images/keshe.jpg)">
<center><h1>修改界面</h1>
<%
Student student=(Student)request.getSession().getAttribute("sm");
%>
<h3>该用户ID为<%=student.getUser_id() %></h3>
<form action="${pageContext.request.contextPath }/student/update.do">
用户名id:<input type="text" name="userid" value="<%=student.getUser_id()%>"/><br/>
真实姓名:<input type="text" name="realname" value="<%=student.getReal_name() %>"/><br/>
密码:<input type="text" name="password" value="<%=student.getPassword() %>"/><br/>
男<input type="radio" name="status" <%if(student.getSex().equals("男")){ %>checked="checked" <%} %>  value="男"/>&nbsp;&nbsp;
女<input type="radio" name="status" <%if(student.getSex().equals("女")){ %>checked="checked" <%} %> value="女"/><br/>
验证码:<img id="num" src="${pageContext.request.contextPath }/code/code.do"/><input type="text" name="code" /><br/>
<input type="submit" value="修改"/>
</form>
<br/>
<form action="${pageContext.request.contextPath }/student/dating.do">
<input type="submit" value="返回"/>
</form>
</center>
</body>
</html>