<%-- 
	后台显示所有商品页面
	@author: luoxn28
	@date: 2016.5.22
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>显示所有商品 - bookstore</title>
</head>
<body>
	<%@ include file="../util/admin_head.jsp" %>
	
	<c:forEach var="product" items="${products}">
		商品id:${product.id} <br/>
		商品名:${product.name} <br/>
		价&nbsp;格:${product.price} <br/>
		种&nbsp;类:${product.category} <br/>
		库&nbsp;存:${product.num} <br/>
		图片url:${product.imgurl} <br/>
		描&nbsp;述:${product.description} <br/>
		<hr/>
	</c:forEach>

</body>
</html>