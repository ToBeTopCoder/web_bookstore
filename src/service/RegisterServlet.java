package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;

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
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String telephone = request.getParameter("telephone");
		String introduce = request.getParameter("introduce");

		User user = new User();
		UserDao userDao = new UserDao();
		
		if (userDao.getUserByName(username) != null) {
			out.println("该会员名已存在，请大爷更改！2秒后跳转到登录页面");
			
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(telephone);
		user.setIntroduce(introduce);
		
		userDao.insertUser(user);
		out.println("注册成功，2秒后跳转到登录页面");
		response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
	}
}
