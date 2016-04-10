<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
	<style type="text/css">
		.text_right {
			text-align: right;
			color: blue;
		}
	</style>
	
	<script type="text/javascript">
		function validate_form(form) {
			var name = form.name.value;
			var price = form.price.value;
			
			if (name == null || name == "" || price == null || price == "") {
				alert("商品名或者价格为空");
				return false;
			}
		}
		
	</script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>管理员页面 - bookstore</title>
</head>
<body>
	<div class="text_right" >
		<a href="${pageContext.request.contextPath}/client/register.jsp">注册</a>
		<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>
	</div>
	
	<div>
		<hr color="blue"/>
		<h4>添加书籍</h4>
		<form action="${pageContext.request.contextPath}/AddProductionServlet" method="post" onsubmit="return validate_form(this)">
			商品名:<input type="text" name="name"/> <br/>
			价&nbsp;格:<input type="text" name="price"/> <br/>
			分&nbsp;类:<select name="category">
				<option value="null">--请选择--</option>
				<option value="computer">计算机</option>
				<option value="economic">经济</option>
			</select> <br/>
			数&nbsp;量:<input type="text" name="pnum"/> <br/>
			图&nbsp;片:<input type="file" name="imgurl"/> <br/>
			描&nbsp;述:<textarea name="description"></textarea> <br/>
			&nbsp;&nbsp;&nbsp;<input type="submit" value="提交" /> <input type="reset" />
		</form>
	</div>
</body>
</html>