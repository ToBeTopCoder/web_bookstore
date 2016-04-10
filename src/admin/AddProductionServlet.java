package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Production;
import dao.ProductionDao;

@WebServlet(name="AddProductionServlet", urlPatterns={"/AddProductionServlet"})
public class AddProductionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		String pnum = request.getParameter("pnum");
		//String imgurl = request.getParameter("imgurl");
		String description = request.getParameter("description");
		
		// 表单验证使用javascript
		Production production = new Production();
		ProductionDao productionDao = new ProductionDao();
		
		production.setName(name);
		production.setPrice(price);
		production.setCategory(category);
		if (pnum != "") {
			production.setPnum(Integer.parseInt(pnum));
		}
		production.setDescript(description);
		
		productionDao.insertProduction(production);
		out.println("添加商品成功，2秒后跳转到管理员页面");
		response.addHeader("refresh", "2;url=" + request.getContextPath() + "/admin/index.jsp");
	}
}
