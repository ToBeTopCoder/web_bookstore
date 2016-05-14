package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;

/*
 * 用户登录Servlet
 * @author: luoxn28
 * @date: 2016.5.14
 */
@WebServlet(name="LoginServlet", urlPatterns={"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/client/login.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		
		User user = userDao.getUser(username);
		if (user == null) {
			out.println("抱歉，你当前还未注册，2秒后调到注册页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		else if (!user.getPassword().equals(password)) {
			out.println("抱歉，输入密码错误，2秒后调到登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}
		else if (user.getState() == 0) {
			// 未激活
			out.println("抱歉，你当前还未激活，请联系管理员，2秒后调到登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}

		// 登录成功，将用户存储到session
		request.getSession().setAttribute("user" + user.getId(), user);
		// 添加cookie，cookie信息为 user:id
		Cookie cookie = new Cookie("user", String.valueOf(user.getId()));
		response.addCookie(cookie);
		
		// 判断用户是否是管理员
		String role = user.getRole();
		if (role.equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
			return;
		}
		else {
			response.sendRedirect(request.getContextPath() + "/client/index.jsp");
		}
	}
}
