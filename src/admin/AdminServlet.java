package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;

@WebServlet(name="AdminServlet", urlPatterns={"/AdminServlet"})
public class AdminServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserByName(username);
		if (user == null || user.getIsAdmin() == 0) {
			out.println("大爷请回，您不是管理员！2秒后跳转到登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/register.jsp");
			return;
		}
		
		if (!password.equals(user.getPassword())) {
			out.println("密码貌似错了，2秒后跳转到管理员登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/admin/login.jsp");
			return;
		}
		
		response.addHeader("refresh", "0;url=" + request.getContextPath() + "/admin/index.jsp");
	}
}
