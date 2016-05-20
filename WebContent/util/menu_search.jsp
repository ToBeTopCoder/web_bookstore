<%-- 
	网页头部信息
	@author: luoxn28
	@date: 2016.5.15
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div id="book_menu">
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=文学">文学</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=生活">生活</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=计算机">计算机</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=外语">外语</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=经营">经营</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=励志">励志</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=社科">社科</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=学术">学术</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=少儿">少儿</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=艺术">艺术</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=原版">原版</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=科技">科技</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=考试">考试</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=生活百科">生活百科</a>
	<a href="${pageContext.request.contextPath}
		/ShowProductByCategoryServlet?category=全部商品">全部商品目录</a>
</div>

<div id="book_search">
	<form action="${pageContext.request.contextPath}/MenuSearchServlet" method="get">
		Search<input type="text" name="findBook" value="请输入书名"/>
		<input type="submit" value="搜索"/>
	</form>
</div>