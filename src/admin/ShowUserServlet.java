package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;

/*
 * 后台显示所有用户Servlet
 * @author: luoxn28
 * @date: 2016.5.22
 */
@WebServlet(name="ShowUserServlet", urlPatterns={"/ShowUserServlet"})
public class ShowUserServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		List<User> users = userDao.getAllUser();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/admin/show_user.jsp").forward(request, response);
	}
}
