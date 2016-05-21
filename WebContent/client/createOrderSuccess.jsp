<%-- 
	结算页面
	@author: luoxn28
	@date: 2016.5.18
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>结算页面 - bookstore</title>
</head>
<body>
	<%@ include file="../util/head.jsp" %>
	<%@ include file="../util/menu_search.jsp" %>

	<form action="${pageContext.request.contextPath}/OrderSuccessServlet">
		支付宝:<input type="text" name="account"/> <br/>
		密&nbsp;码:<input type="password" name="password"/>
		<input type="submit" value="确定"/>
	</form>
</body>
</html>