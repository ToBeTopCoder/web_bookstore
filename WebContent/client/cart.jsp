<%-- 
	购物车页面
	@author: luoxn28
	@date: 2016.5.15
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Product, java.util.HashMap" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ page import="util.ServletUtils" %>
<%@ page import="javax.servlet.http.Cookie" %>

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

	<%
		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie == null) {
			response.getWriter().println("抱歉，你当前还未登录，2秒后调到登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}
		String userId = "cart" + cookie.getValue();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute(userId);
		if (cart == null) {
			response.getWriter().println("抱歉，你当前还未购买任何商品，2秒后调到主页");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/index.jsp");
			return;
		}
	%>

	<table border="1" cellspacing="0" id="cart_table">
		<tr>
			<td>序号</td>
			<td>商品名称</td>
			<td>价格</td>
			<td>数量</td>
			<td>库存</td>
			<td>小计</td>
			<td>删除</td>
		<tr>
		<c:set var="total" value="0" scope="page"/>
		<c:forEach var="entry" items="<%= cart %>" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${entry.key.name}</td>
			<td>${entry.key.price}</td>
			<td>${entry.value}</td>
			<td>${entry.key.num}</td>
			<td>${entry.key.price * entry.value}</td>
			<td><a href="${pageContext.request.contextPath}/ChangeCartServlet?id=${entry.key.id}">删除</a></td>			
			<c:set var="total" value="${total + entry.key.price * entry.value}"/>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="7" style="text-align: right">
				合计:${total}元
			</td>
		</tr>
		<tr>
			<td colspan="7" style="text-align: right">
				<a href="${pageContext.request.contextPath}/client/index.jsp">
					<b>继续购物</b>
				</a>
				<a href="${pageContext.request.contextPath}/client/order.jsp">
					<b>现在结账</b>
				</a>
			</td>
		</tr>
	</table>
	
</body>
</html>