<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="dao.UserDao, dao.User"%>
<%@ page import="java.util.List" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>显示所有用户- bookstore</title>
</head>
<body>
	<div style="text-align: right;">
		<a href="${pageContext.request.contextPath}/admin/index.jsp">回到主页</a>
	</div> <hr/>
	
	<%
		UserDao userDao = new UserDao();
		List<User> users = userDao.getAllUser();
		for (User user : users) {
		%>
			<div>
				用户名:<%= user.getUsername() %> <br/>
				密&nbsp;码:<%= user.getPassword() %> <br/>
				邮&nbsp;箱:<%= user.getEmail() %> <br/>
				性&nbsp;别:<%= user.getSex() %> <br/>
				手&nbsp;机:<%= user.getPhone() %> <br/>
				介&nbsp;绍:<%= user.getIntroduce() %> <br/>
				管理员:<%= user.getIsAdmin() %>
			</div>
			<hr/>
		<%
		}
	%>
</body>
</html>