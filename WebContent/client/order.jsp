<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dao.User"%>
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
	
</body>
</html>