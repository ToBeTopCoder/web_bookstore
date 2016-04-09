package demo;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import dao.Production;
import dao.ProductionDao;
import dao.User;
import dao.UserDao;

public class Demo_c3p0 {
	public static DataSource ds = null;
	
	static {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		ds = cpds;
	}
	
	public static void main(String[] args) throws SQLException {
//		Connection connection = (Connection) ds.getConnection();
//		
//		java.sql.DatabaseMetaData metaData = connection.getMetaData();
//		
//		System.out.println(metaData.getURL());
//		System.out.println(metaData.getUserName());
//		System.out.println(metaData.getDriverName());
		
		{
//			// 测试插入User
//			User user = new User();
//			UserDao userDao = new UserDao();
//			
////			user.setUsername("luoxn28");
////			user.setPassword("123456");
////			user.setEmail("luoxn28@163.com");
//			
//			user = userDao.getUserByName("luoxn28");
//			if (user != null) {
//				System.out.println("query ok");
//				System.out.println(user.getUsername());
//				System.out.println(user.getPassword());
//				System.out.println(user.getEmail());
//			}
		}
		
		{
			// 测试插入Products
			Production production = new Production();
			ProductionDao productionDao = new ProductionDao();
			
//			production.setName("Java编程思想");
//			production.setPrice(49.99);
			
			production = productionDao.getProductionByName("Java编程思想");
			if (production != null) {
				System.out.println("query ok");
				System.out.println(production.getName());
				System.out.println(production.getPrice());
			}
		}
	}
}
