<%-- 
	用户主页
	@author: luoxn28
	@date: 2016.5.15
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>用户主页 - bookstore</title>
</head>
<body>
	<%@ include file="../util/head.jsp" %>
	<%@ include file="../util/menu_search.jsp" %>
	
	<form action="${pageContext.request.contextPath}/AddCarServlet" method="post">
		Java Web编程 <br/>
		<input type="text" name="id" value="1"/>
		<input type="submit" value="购买"/>
	</form>
</body>
</html>