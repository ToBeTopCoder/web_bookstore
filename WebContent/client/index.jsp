<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.User"%>
<%@ page import="dao.Production, dao.ProductionDao" %>
<%@ page import="java.util.List" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>会员页面 - bookstore</title>
</head>
<body>
	<div style="text-align: right; color: blue;" >
		<a href="${pageContext.request.contextPath}/client/cart.jsp">查看购物车</a>
	</div>
	
	<%
		String cookie = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("user")) {
				cookie = cookies[i].getValue();
			}
		}
		System.out.println(cookie);
		User user = (User) session.getAttribute(cookie);
		if (user != null) {
			out.println("你好，" + user.getUsername());
		}
	%>
	<hr/>
	<%
		ProductionDao productionDao = new ProductionDao();
		List<Production> productions = productionDao.getAllProduction();
		for (Production production : productions) {
		%>
			<div>
				商品名:<%= production.getName() %> <br/>
				价&nbsp;格:<%= production.getPrice() %> <br/>
				分&nbsp;类:<%= production.getCategory() %> <br/>
				数&nbsp;量:<%= production.getPnum() %> <br/>
				描&nbsp;述:<%= production.getDescription() %> <br/>
				<a href=<%= request.getContextPath()+"/BuyServlet?id="+production.getId() %>>加入购物车</a>
			</div>
			<hr/>
		<%
		}
	%>
</body>
</html>