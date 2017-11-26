<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"
	import="web2017.team8.liuwangsen.entity.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>主界面</title>
</head>
<body>
	${user.userName},欢迎您进入后台主界面！<br/>
	 以下为用户列表信息：<br/>
	<table border="1">
		<tr>
			<th>用户编号</th>
			<th>用户名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>电话</th>
			<th>操作</th>
		</tr>
		<%
			List<User> userList = (List<User>) request.getAttribute("userList");
		    System.out.println(userList);
			for (User user : userList)
			{
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getUserName()%></td>
			<td><%=user.getAge()%></td>
			<td><%=user.getSex()%></td>
			<td><%=user.getTel()%></td>
			<td><a href="update.jsp?userName=<%=user.getUserName()%>">修改</a> 
				<a href="delete.html?userName=<%=user.getUserName()%>">删除</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<form action="login.jsp">
		<input type="submit" value="退出" />
	</form>

</body>
</html>