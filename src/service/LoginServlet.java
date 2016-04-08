package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		out.println("您好 " + username);
	}
}
