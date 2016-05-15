package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*
 * Servlet相关工具类
 * @author: luoxn28
 * @date: 2016.5.15
 */
public class ServletUtils {
	/*
	 * 根据name获取对应的cookie
	 * @param name: cookie的name
	 * @return Cookie: name对应的cookie，未找到返回null
	 */
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals(name)) {
				return (Cookie) cookies[i].clone();
			}
		}
		return null;
	}
}
