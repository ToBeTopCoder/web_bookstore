
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
		alert("密码和重复密码不一致");
		return false;
	}
}