<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
	<style type="text/css">
		.text_right {
			text-align: right;
			color: blue;
		}
	</style>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>管理员页面 - bookstore</title>
</head>
<body>
	<div class="text_right" >
		<a href="${pageContext.request.contextPath}/client/register.jsp">注册</a>
		<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>
	</div>
	<hr color="blue"/>
	
	<a href="${pageContext.request.contextPath}/admin/add_production.jsp">添加商品</a>
	<a href="${pageContext.request.contextPath}/admin/show_production.jsp">所有商品</a>
	<hr color="blue"/>
</body>
</html>