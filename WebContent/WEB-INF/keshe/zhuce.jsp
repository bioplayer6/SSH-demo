<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册界面</title>
</head>
<body style="background: url(${pageContext.request.contextPath }/images/keshe1.jpg)">
<center>
<h1>欢迎注册</h1>
<form method="post" action="${pageContext.request.contextPath }/student/register.do">
用户名id:<input type="text" name="userid"/><br/>
真实姓名:<input type="text" name="realname"/><br/>
密码:<input type="password" name="password"/><br/>
男<input type="radio" name="status" checked="checked" value="男"/>&nbsp;&nbsp;
女<input type="radio" name="status" value="女"/><br/>
验证码:<img id="num" src="${pageContext.request.contextPath }/code/code.do"/><input type="text" name="code" /><br/>
<input type="submit" value="注册"/>
</form>
<br/>
<form action="${pageContext.request.contextPath }/student/entry.do">
<input type="submit" value="返回"/>
</form>
</center>
</body>
</html>