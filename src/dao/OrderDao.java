package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class OrderDao {
	public static DataSource ds = null;
	
	public void insertOrder(Order order) {
		if (order == null) {
			return;
		}
		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = (Connection) cpds.getConnection();
			
			String sql = "insert orders (price, recv_name, recv_phone, recv_address, user_id)"
					+ "value(?, ?, ?, ?, ?)";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			
			statement.setDouble(1, order.getPrice());
			statement.setString(2, order.getRecvName());
			statement.setString(3, order.getRecvPhone());
			statement.setString(4, order.getRecvAddress());
			statement.setInt(5, order.getUserId());
			statement.executeUpdate();
			
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Order> getOrderByUserId(int userId) {
		List<Order> orders = new ArrayList<Order>();
		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = cpds.getConnection();
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders where user_id=" + userId);
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("id"));
				order.setPrice(resultSet.getDouble("price"));
				order.setRecvName(resultSet.getString("recv_name"));
				order.setRecvPhone(resultSet.getString("recv_phone"));
				order.setRecvAddress(resultSet.getString("recv_address"));
				order.setUserId(resultSet.getInt("user_id"));
				orders.add(order);
			}
			resultSet.close();
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public List<Order> getAllOrder() {
		List<Order> orders = new ArrayList<Order>();
		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = cpds.getConnection();
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("id"));
				order.setPrice(resultSet.getDouble("price"));
				order.setRecvName(resultSet.getString("recv_name"));
				order.setRecvPhone(resultSet.getString("recv_phone"));
				order.setRecvAddress(resultSet.getString("recv_address"));
				order.setUserId(resultSet.getInt("user_id"));
				orders.add(order);
			}
			resultSet.close();
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
