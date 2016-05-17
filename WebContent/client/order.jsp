<%-- 
	订单页面
	@author: luoxn28
	@date: 2016.5.17
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="dao.Product, java.util.Map, java.util.HashMap" %>
<%@ page import="util.ServletUtils" %>
<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>订单页面 - bookstore</title>
</head>
<body>
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
			<td>类别</td>
			<td>小计</td>
		<tr>
		<c:set var="total" value="0" scope="page"/>
		<c:forEach var="entry" items="<%= cart %>" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${entry.key.name}</td>
			<td>${entry.key.price}</td>
			<td>${entry.value}</td>
			<td>${entry.key.category}</td>
			<td>${entry.key.price * entry.value}</td>
			<c:set var="total" value="${total + entry.key.price * entry.value}"/>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6" style="text-align: right">
				合计:${total}元
			</td>
		</tr>
		<tr>
			<td colspan="6" style="text-align: left">
				<div>
					收货地址:<input type="text" name="address"/> <br/>
					收货人:<input type="text" name="name"/> <br/>
					电话:<input type="text" name="phone"/>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="6" style="text-align: right">
				<a href="${pageContext.request.contextPath}/CreateOrderServlet">
					<b>提交订单</b>
				</a>
			</td>
		</tr>
	</table>
	
</body>
</html>