<%-- 
	管理员页面head
	@author: luoxn28
	@date: 2016.5.21
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Date" %>

<div id="admin_head">
	<b>网上书城--后台管理系统</b> 
	<div style="text-align: right"><%= new Date() %></div>
	
	<a href="${pageContext.request.contextPath}/admin/add_production.jsp">添加商品</a>
	<a href="${pageContext.request.contextPath}/admin/show_production.jsp">所有商品</a>
	<a href="${pageContext.request.contextPath}/admin/show_user.jsp">所有用户</a>
</div>