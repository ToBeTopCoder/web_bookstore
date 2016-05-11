package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 工具类 DataSourceUtils
 * @author: luoxn28
 * @date: 2016.5.11
 */
public class DataSourceUtils {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	/*
	 * 当DBUtils需要手动控制事务时，调用该方法获得一个连接
	 * @return 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		Connection connection = threadLocal.get();
		if (connection == null) {
			connection = dataSource.getConnection();
			threadLocal.set(connection);
		}
		return connection;
	}
	
	/*
	 * 开启事务
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		Connection connection = getConnection();
		if (connection == null) {
			connection.setAutoCommit(false);
		}
	}
	
	/*
	 * 从ThreadLocal中释放并且关闭Connection，并结束事务
	 * @throws SQLException
	 */
	public static void releaseAndCloseConnection() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.commit();
			threadLocal.remove();
			connection.close();
		}
	}
	
	/*
	 * 事务回滚
	 * @throws SQLException
	 */
	public static void roolback() throws SQLException {
		Connection connection = getConnection();
		if (connection != null) {
			connection.rollback();
		}
	}
}
