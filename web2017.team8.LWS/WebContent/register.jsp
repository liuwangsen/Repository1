<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册页面</title>
</head>
<body>
<form action="<c:url value="/register.html"/>" >  
    用户名：
    <input type="text" name="userName">
    <br>
    密 码：
    <input type="text" name="password">
    <br>
     年龄：
    <input type="text" name="age">
    <br>
    电话：
    <input type="text" name="tel">
    <br>
    性别：
    <input type="text" name="sex">
    <br>
    
    <input type="submit" value="注册"/>
</form>


</body>
</html>