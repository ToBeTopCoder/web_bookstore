<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.User"%>
<%@ page import="dao.Production, dao.ProductionDao" %>
<%@ page import="java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>结算页面 - bookstore</title>
</head>
<body>
	<%
		String cookie = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("user")) {
				cookie = cookies[i].getValue();
			}
		}

		User user = (User) session.getAttribute(cookie);
		if (user != null) {
			out.println("你好，" + user.getUsername());
		}
		else {
			out.println("亲，你还没有登陆呢，1秒后调到登陆页面");
			response.addHeader("refresh", "1;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}
	%>
	<hr/>
	<%
		String[] ids = cookie.split("-");
		Map<Integer, Production> cart = (Map<Integer, Production>) session.getAttribute("cart" + ids[1]);
		if (cart != null) {
			double sum = 0.0;
			Set<Integer> keys = cart.keySet();
			for (Integer id : keys) {
				Production production = cart.get(id);
				sum += production.getPrice() * production.getPnum();
		%>
			<div>
				商品名:<%= production.getName() %> <br/>
				价&nbsp;格:<%= production.getPrice() %> <br/>
				数&nbsp;量:<%= production.getPnum() %> <br/>
			</div>
			<hr/>
		<%
			}
			%>
			总价:<%= sum %>
			<hr>
			<div style="text-align: center;">
				<form action="${pageContext.request.contextPath}/OrderServlet" method="post">
					价&nbsp;格:<input type="text" name="price" value="<%= sum %>"/> <br/>
					收件人:<input type="text" name="recv_name" value="<%= user.getUsername() %>"/> <br/>
					手&nbsp;机:<input type="text" name="recv_phone" value="<%= user.getPhone() %>"/> <br/>
					地&nbsp;址:<input type="text" name="recv_address"/> <br/>
					<input type="hidden" name="user_id" value="<%= user.getId() %>"/>
					<input type="submit" value="结算"/>
				</form>
			</div>
			<%
		}
	%>
	
</body>
</html>