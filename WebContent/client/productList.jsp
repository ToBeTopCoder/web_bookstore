<%-- 
	商品页面
	@author: luoxn28
	@date: 2016.5.19
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>商品页面 - bookstore</title>
</head>
<body>
	<%@ include file="../util/head.jsp" %>
	<%@ include file="../util/menu_search.jsp" %>

	<c:forEach var="product" items="${productSet}">
		商品名:${product.name} <br/>
		价&nbsp;格:${product.price} <br/>
		种&nbsp;类${product.category} <br/>
		库&nbsp;存:${product.num} <br/>
		图&nbsp;片:${product.imgurl} <br/>
		描&nbsp;述${product.description} <br/>
		<hr/>
	</c:forEach>
</body>
</html>