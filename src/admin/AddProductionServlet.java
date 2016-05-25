package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Product;
import dao.ProductDao;

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
		Product product = new Product();
		product.setName(name);
		product.setPrice(Double.valueOf(price));
		product.setCategory(category);
		product.setNum(Integer.valueOf(num));
		product.setDescription(description);
		
		ProductDao productDao = new ProductDao();
		productDao.addProduct(product);
		
		response.getWriter().println("添加商品成功，2秒后跳转到管理员主页");
		response.setHeader("Refresh", "2;url=" + request.getContextPath() + "/admin/index.jsp");
	}
}
