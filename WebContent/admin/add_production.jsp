<%-- 
	后台添加商品页面
	@author: luoxn28
	@date: 2016.5.22
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>添加商品 - bookstore</title>
</head>
<body>
	<%@ include file="../util/admin_head.jsp" %>

	<form action="${pageContext.request.contextPath}/AddProductionServlet" method="post" onsubmit="return validate_add_product(this)">
		商品名:<input type="text" name="name"/> <br/>
		价&nbsp;格:<input type="text" name="price"/> <br/>
		分&nbsp;类:<select name="category">
			<option value="null">--请选择--</option>
			<option value="文学">文学</option>
			<option value="生活">生活</option>
			<option value="计算机">计算机</option>
			<option value="外语">外语</option>
			<option value="经营">经营</option>
			<option value="励志">励志</option>
			<option value="社科">社科</option>
			<option value="学术">学术</option>
			<option value="少儿">少儿</option>
			<option value="艺术">艺术</option>
			<option value="原版">原版</option>
			<option value="科技">科技</option>
			<option value="考试">考试</option>
			<option value="生活百科">生活百科</option>
		</select> <br/>
		数&nbsp;量:<input type="text" name="num"/> <br/>
		图&nbsp;片:<input type="file" name="imgurl"/> <br/>
		描&nbsp;述:<textarea name="description"></textarea> <br/>
		&nbsp;&nbsp;&nbsp;<input type="submit" value="提交" /> <input type="reset" />
	</form>
	
</body>
</html>