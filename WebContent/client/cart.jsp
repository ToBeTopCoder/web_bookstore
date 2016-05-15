<%-- 
	购物车页面
	@author: luoxn28
	@date: 2016.5.15
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>购物车页面 - bookstore</title>
</head>
<body>
	<%@ include file="../util/head.jsp" %>
	<%@ include file="../util/menu_search.jsp" %>
	
	这里是购物车啦
	<c:if test="${cookie['user'] != null}">
		<c:set var="userId" value="${cookie['user'].value}"/>
		${userId}
	</c:if>
	
	<c:set var="cartId" value="cart${userId}"></c:set>
	<c:set var="total" value="0"/>
	<c:forEach var="entry" items="${cartId}" varStatus="vs">
		<table witdth="100%" border="0" cellspacing="0">
			<tr>
				<td width="10%">${vs.count}</td>
				${entry}
			</tr>
		</table>
	</c:forEach>
	 
</body>
</html>