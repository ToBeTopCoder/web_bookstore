<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.User"%>
<%@ page import="dao.Production, dao.ProductionDao" %>
<%@ page import="java.util.*" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>购物车页面 - bookstore</title>
</head>
<body>
	<div style="text-align: right">
		<a href="${pageContext.request.contextPath}/client/index.jsp">继续购物</a>
	</div>
	<hr color="blue"/>
	
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
			Set<Integer> keys = cart.keySet();
			for (Integer id : keys) {
				Production production = cart.get(id);
		%>
			<div>
				商品名:<%= production.getName() %> <br/>
				价&nbsp;格:<%= production.getPrice() %> <br/>
				数&nbsp;量:<%= production.getPnum() %> <br/>
			</div>
			<hr/>
		<%
			}
		}
	%>
</body>
</html>