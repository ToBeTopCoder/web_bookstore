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
 * 后台添加商品Servlet
 * @author: luoxn28
 * @date: 2016.5.22
 */
@WebServlet(name="AddProductionServlet", urlPatterns={"/AddProductionServlet"})
public class AddProductionServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		String num = request.getParameter("num");
		//String imgurl = request.getParameter("imgurl");
		String description = request.getParameter("description");
		
		// 添加商品到数据表
		
		response.getWriter().println("添加商品成功，2秒后跳转到管理员主页");
		response.setHeader("Refresh", "2;url=" + request.getContextPath() + "/admin/index.jsp");
	}
}
