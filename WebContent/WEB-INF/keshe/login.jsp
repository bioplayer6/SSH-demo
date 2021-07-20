<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录界面</title>
</head>
<body style="background: url(${pageContext.request.contextPath }/images/keshe1.jpg)">
<center><h1>登录界面</h1><br/>
<form method="post" action="${pageContext.request.contextPath }/student/login.do">
用户名:&nbsp;&nbsp;<input type="text" name="user"><br/><br/>
密码:&nbsp;&nbsp;<input type="password" name="password"><br/><br/>
验证码:<img id="num" src="${pageContext.request.contextPath }/code/code.do"/><input type="text" name="code" /><br/><br/>
<input type="submit" value="登录"><br/><br/>
</form>
<form action="${pageContext.request.contextPath }/student/zhuce.do">
<input type="submit" value="注册">
</form>
</center>

</body>
</html>