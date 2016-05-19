package service;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Product;
import dao.ProductDao;

/*
 * 搜索栏功能类
 * @author: luoxn28
 * @date: 2016.5.19
 */
@WebServlet(name="MenuSearchServlet", urlPatterns={"/MenuSearchServlet"})
public class MenuSearchServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String findBook = request.getParameter("findBook");
		if (findBook != null && findBook.length() > 0 && !findBook.equals("请输入书名")) {
			ProductDao productDao = new ProductDao();
			Set<Product> set = productDao.getProductBySearchName(findBook);
			if (set != null) {
				request.setAttribute("productSet", set);
			}
		}
		request.getRequestDispatcher("/client/productList.jsp").forward(request, response);
	}
}
