package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User;
import dao.UserDao;

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
		
		User user = userDao.getUserByName(username);
		if (user == null) {
			out.println("大爷好，您当前还未注册，2秒后调到注册页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		
		if (user.getIsAdmin() != 0) {
			// 管理员
			request.getRequestDispatcher("/AdminServlet").forward(request, response);
			return;
		}
		
		// 普通会员
		if (!password.equals(user.getPassword())) {
			out.println("密码貌似错了，2秒后跳转到会员登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}
		
		// 添加 user-id session
		HttpSession session = request.getSession();
		User cachedUser = (User) session.getAttribute("user-" + user.getId());
		if (cachedUser == null) {
			session.setAttribute("user-" + user.getId(), user);
		}
		
		// 添加cookie，cookie信息为 user-id
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("user")) {
				out.println("你已成功登陆，1秒中后调到主页");
				response.addHeader("refresh", "1;url=" + request.getContextPath() + "/client/index.jsp");
				return;
			}
		}
		Cookie cookie = new Cookie("user", "user-" + user.getId());
		response.addCookie(cookie);
		
		response.addHeader("refresh", "0;url=" + request.getContextPath() + "/client/index.jsp");
	}
}
