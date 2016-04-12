package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Production;
import dao.ProductionDao;

@WebServlet(name="BuyServlet", urlPatterns={"/BuyServlet"})
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String cookie = "";

		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("user")) {
				cookie = cookies[i].getValue();
			}
		}
		
		if (cookie.equals("")) {
			out.println("亲，你还没有登陆呢，1秒后调到登陆页面");
			response.addHeader("refresh", "1;url=" + request.getContextPath() + "/client/login.jsp");
			return;
		}

		String id = request.getParameter("id");
		ProductionDao productionDao = new ProductionDao();
		Production production = productionDao.getProductionById(Integer.parseInt(id));
		if (production != null) {
			// 将商品放入购物车中
			String[] ids = cookie.split("-");
			HttpSession session = request.getSession();	
			Map<Production, Integer> cart = (Map<Production, Integer>) session.getAttribute("cart" + ids[1]);
			if (cart == null) {
				cart = new LinkedHashMap<Production, Integer>();
			}
			
			if (cart.containsKey(production)) {
				int num = cart.get(production);
				cart.put(production, num + 1);
			}
			else {
				cart.put(production, 1);
			}
			session.setAttribute("cart" + ids[1], cart);
			
			out.println("添加购物车成功<br/>");
			out.println("<a href='"+request.getContextPath()+"/client/index.jsp'>继续购物</a>");
			out.println("<a href='"+request.getContextPath()+"/client/cart.jsp'>查看购物车</a>");
			//session.setAttribute("cart", );
			//cart = new ArrayList<Book>();
			//session.setAttribute("cart", cart);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
