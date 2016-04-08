package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

public class AdminPrivateFilter implements Filter {
	@Override
	public void init(FilterConfig config) {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		User user = (User) request.getSession().getAttribute("user");
		if (user != null && "admin".equals(user.getRoles())) {
			chain.doFilter(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath() + "/error/adminPrivate.jsp");
	}
	
	@Override
	public void destroy() {	}
}
