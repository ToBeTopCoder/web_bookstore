package service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Product;
import dao.ProductDao;
import util.ServletUtils;

/*
 * 删除购物车商品类ChangeCartServlet
 * @author: luoxn28
 * @date: 2016.5.17
 */
@WebServlet(name="ChangeCartServlet", urlPatterns={"/ChangeCartServlet"})
public class ChangeCartServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取对应的商品id
		String id = request.getParameter("id");
		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie != null && id != null && id.length() > 0) {
			ProductDao productDao = new ProductDao();
			Product product = productDao.getProduct(Integer.valueOf(id));
			if (product != null) {
				HttpSession session = request.getSession();
				Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart" + cookie.getValue());
				cart.remove(product);
			}
		}
		response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
	}
}
