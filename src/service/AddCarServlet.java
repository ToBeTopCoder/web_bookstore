package service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Product;
import dao.ProductDao;
import dao.User;
import dao.UserDao;
import util.ServletUtils;

/*
 * 加入购物车Servlet
 * @author: luoxn28
 * @date: 2016.5.15
 */
@WebServlet(name="AddCarServlet", urlPatterns={"/AddCarServlet"})
public class AddCarServlet  extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 先判断用户是否登录
		Cookie cookie = ServletUtils.getCookie(request, "user");
		if (cookie == null) {
			response.getWriter().println("抱歉，你当前还未登录，2秒后调到登录页面");
			response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}
		
		// 获取商品id
		String id = request.getParameter("id");
		// 获取商品信息
		ProductDao productDao = new ProductDao();
		Product product = productDao.getProduct(Integer.valueOf(id));
		if (product == null) {
			// 一般不会出现为null情况
			return;
		}
		
		// 获取购物车对象
		HttpSession session = request.getSession();
		Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart" + cookie.getValue());
		if (cart == null) {
			cart = new HashMap<Product, Integer>();
		}
		
		// 如果购物车包含该商品，则加1
		if (cart.containsKey(product)) {
			Integer num = cart.get(product);
			cart.put(product, num + 1);
		}
		else {
			cart.put(product, 1);
		}
		
		session.setAttribute("cart" + cookie.getValue(), cart);
		response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
	}
}
