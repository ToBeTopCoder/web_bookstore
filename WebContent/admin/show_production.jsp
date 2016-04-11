<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.Production, dao.ProductionDao" %>
<%@ page import="java.util.List" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>显示所有商品 - bookstore</title>
</head>
<body>
	<div style="text-align: right;">
		<a href="${pageContext.request.contextPath}/admin/index.jsp">回到主页</a>
	</div> <hr/>
	
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
			</div>
			<hr/>
		<%
		}
	%>
</body>
</html>