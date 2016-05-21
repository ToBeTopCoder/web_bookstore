package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 订单结算成功Servlet
 * @author: luoxn28
 * @date: 2016.5.21
 */
@WebServlet(name="OrderSuccessServlet", urlPatterns={"/OrderSuccessServlet"})
public class OrderSuccessServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("你好，已成功支付，你的包裹正向你飞奔而来！！！ 2秒后回到主页");
		response.addHeader("refresh", "2;url=" + request.getContextPath() + "/client/index.jsp");
	}
}
