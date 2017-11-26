<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改信息</title>
</head>
<body>
<% String userName = request.getParameter("userName"); %> 
<form action="update.html"> 
      用户名：
	<input type="text" name="userName" value="<%=userName%>" readonly>
    <br>
      电话修改为：
    <input type="text" name="tel">
    <br>
    <input type="submit" value="确认"/>
</form>

</body>
</html>