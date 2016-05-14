package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;

/*
 * 用户注册Servlet
 * @author: luoxn28
 * @date: 2016.5.13
 */
@WebServlet(name="RegisterServlet", urlPatterns={"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/client/register.jsp");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		// 表单验证使用javascript
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String introduce = request.getParameter("introduce");

		UserDao userDao = new UserDao();
		if (userDao.getUser(username) != null) {
			out.println("你好，该用户已存在，2秒后跳转到注册页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		user.setIntroduce(introduce);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		user.setRegistTime(dateFormat.format(new Date()));
		userDao.addUser(user);

		out.println("注册成功，2秒后跳转到登录页面");
		response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
	}
}
