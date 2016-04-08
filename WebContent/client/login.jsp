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
	<title>登录页面 - bookstore</title>
</head>
<body>
	<div class="text_right" >
		<a href="${pageContext.request.contextPath}/client/register.jsp">注册</a>
		<a href="${pageContext.request.contextPath}/admin/login.jsp">管理员登录</a>
	</div>
	<h4 style="text-align: center">欢迎来到 store</h4>
	<form action="" method="post" style="text-align: center">
		用户名:<input type="text" name="username"/> <br/>
		密&nbsp;码:<input type="password" name="password"/> <br/>
		&nbsp;&nbsp;<input type="submit" value="登录"/>&nbsp;
		<input type="reset" value="重置"/> <br/>
		<div>
			<a href="${pageContext.request.contextPath}/client/register.jsp">&gt;立即注册&lt;</a>
		</div>
	</form>

</body>
</html>