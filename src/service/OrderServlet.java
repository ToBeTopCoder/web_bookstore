package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Order;
import dao.OrderDao;
import dao.Production;
import dao.User;

@WebServlet(name="OrderServlet", urlPatterns={"/OrderServlet"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("结算成功");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String price = request.getParameter("price");
		String recvName = request.getParameter("recv_name");
		String recvPhone = request.getParameter("recv_phone");
		String recvAddress = request.getParameter("recv_address");
		String userId = request.getParameter("user_id");
		
		OrderDao orderDao = new OrderDao();
		Order order = new Order();
		
		order.setPrice(Double.valueOf(price));
		order.setRecvName(recvName);
		order.setRecvPhone(recvPhone);
		order.setRecvAddress(recvAddress);
		order.setUserId(Integer.valueOf(userId));
		orderDao.insertOrder(order);
		out.println("结算成功，2秒后跳转到主页");
		response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/index.jsp");
		
		String cookie = "";
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("user")) {
				cookie = cookies[i].getValue();
				break;
			}
		}
		
		String[] cartId = cookie.split("-");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(cookie);
		if (user != null) {
			Map<Integer, Production> cart = (Map<Integer, Production>) session.getAttribute("cart" + cartId[1]);
			cart.clear();
		}
	}
}
