<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.*"%>

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
			var email = form.email.value;
			var username = form.username.value;
			var password = form.password.value;
			var repassword = form.repassword.value;
			
			if (email == null || email == "") {
				alert("会员邮箱不能为空");
				return false;
			}
			if (username == null || username == "") {
				alert("会员名不能为空");
				return false;
			}
			if (password == null || password == "") {
				alert("密码不能为空");
				return false;
			}
			if (repassword == null || repassword  == "" || repassword != password) {
				alert("密码和重复密码不一致" + password + " " + repassword);
				return false;
			}
		}
	</script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>注册页面 - bookstore</title>
</head>

<body style="text-align: center">
	<div class="text_right" >
		<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>
		<a href="${pageContext.request.contextPath}/admin/login.jsp">管理员登录</a>
	</div>
	<h4>新会员注册</h4>
	<form action="${pageContext.request.contextPath}/RegisterServlet" onsubmit="return validate_form(this)" method="post">
		<table align="center" width="40%" border="0" cellspacing="2" calss="upline">
			<tr>
				<td style="text-align: right; width: 20%">会员邮箱:</td>
				<td style="width: 40%"><input type="text" name="email"></input> </td>
				<td><font color="#999999">请输入有效的邮箱地址</font></td>
			</tr>
			<tr>
				<td style="text-align: right">会员名:</td>
				<td><input type="text" name="username"/></td>
				<td><font color="#999999">请输入会员名(4-20位字符)</font></td>
			</tr>
			<tr>
				<td style="text-align: right">密码:</td>
				<td><input type="password" name="password"/></td>
				<td><font color="#999999">请输入密码(4-20位字符)</font></td>
			</tr>
			<tr>
				<td style="text-align: right">重复密码:</td>
				<td><input type="password" name="repassword"/></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td style="text-align: right">性别:</td>
				<td colspan="2">&nbsp;
					<input type="radio" name="gender" value="man" checked="checked"/>男&nbsp;&nbsp;
					<input type="radio" name="gender" value="woman"/>女</td>
			</tr>
			<tr>
				<td style="text-align: right">手机:</td>
				<td><input type="tel" name="telephone"/></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td style="text-align: right">个人介绍:</td>
				<td colspan="2"><textarea type="textarea" name="introduce"></textarea></td>
			</tr>
			<tr>
				<td>&nbsp;</>
				<td colspan="2"><input type="submit" value="注册"/></td>
			</tr>
		</table>
	</form>

</body>
</html>