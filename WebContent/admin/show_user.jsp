<%-- 
	后台显示所有用户页面
	@author: luoxn28
	@date: 2016.5.22
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="dao.UserDao, dao.User"%>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>显示所有用户- bookstore</title>
</head>
<body>
	<%@ include file="../util/admin_head.jsp" %>
	
	<c:forEach var="user" items="${users}">
		用户id:${user.id} <br/>
		用户名:${user.username} <br/>
		密&nbsp;码:${user.password} <br/>
		性&nbsp;别:${user.gender} <br/>
		邮&nbsp;箱:${user.email} <br/>
		<hr/>
	</c:forEach>
	
</body>
</html>