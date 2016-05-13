<%-- 
	注册页面
	@author: luoxn28
	@date: 2016.5.13
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.*"%>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>注册页面 - bookstore</title>
</head>

<body>
	<%@ include file="../util/head.jsp" %>
	<%@ include file="../util/menu_search.jsp" %>
	
	<div id="register_div">
		<div><h4>新会员注册</h4></div>
		<div style="position: relative;	left: 40px;">
			<form action="${pageContext.request.contextPath}/RegisterServlet" onsubmit="return validate_form(this)" method="post">
				用户名:<input type="text" name="username"/> <br/>
				密&nbsp;码:<input type="password" name="password"/> <br/>
				重&nbsp;复:<input type="password" name="repassword"/> <br/>
				性&nbsp;别:<input type="radio" name="gender" value="男" checked="checked"/>男&nbsp;&nbsp;
					<input type="radio" name="gender" value="女"/>女 <br/>
				邮&nbsp;箱:<input type="text" name="email"/> <br/>
				手&nbsp;机:<input type="text" name="phone"/> <br/>
				介&nbsp;绍:<textarea type="textarea" name="introduce"></textarea> <br/>
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="注册"/>
			</form>
		</div>
	</div>

</body>
</html>