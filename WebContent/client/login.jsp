<%-- 
	注册页面
	@author: luoxn28
	@date: 2016.5.14
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登录页面 - bookstore</title>
</head>
<body>
	<%@ include file="../util/head.jsp" %>
	<%@ include file="../util/menu_search.jsp" %>

	<div id="login_div">
		<div id="login_div_left">
			<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
				<p><h4>个人用户登录</h4></p>
				用户名:<input type="text" name="username"/> <br/>
				密&nbsp;码:<input type="text" name="password"/> <br/>
				&nbsp;<input type="checkbox" name="checkbox" value="checkbox"/>记住用户名&nbsp;&nbsp;
				<input type="checkbox" name="checkbox" value="checkbox"/>自动登录&nbsp; <br/>
				<input type="submit" value="登录"/>
			</form>
		</div>
		<div id="login_div_right">
			<h4>你还没有注册</h4>
			<p>注册新会员，享受优惠价格和完美购书体验。。。</p>
			<p>万种图书，供你选择！赶快注册吧！！！</p>
			<a href="${pageContext.request.contextPath}/client/register.jsp">
				<img alt="点击注册" src="../img/register.png"/>
			</a>
		</div>
	</div>
</body>
</html>