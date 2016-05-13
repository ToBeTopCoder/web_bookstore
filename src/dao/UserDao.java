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

import util.DataSourceUtils;

/*
 * 用户类操作类
 * @author: luoxn28
 * @date: 2016.5.13
 */
public class UserDao {
	public static DataSource ds = null;
	
	/*
	 * 往user表中插入一个用户
	 * @param User
	 * @return void
	 */
	public void addUser(User user) throws SQLException {
		Connection connection = DataSourceUtils.getConnection();
		String sql = "INSERT user (username, password, gender, email, phone, introduce, activeCode, state, role, registTime)"
				+ "value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getGender());
		statement.setString(4, user.getEmail());
		statement.setString(5, user.getPhone());
		statement.setString(6, user.getIntroduce());
		statement.setString(7, user.getActiveCode());
		statement.setInt(8, user.getState());
		statement.setString(9, user.getRole());
		statement.setString(10, user.getRegistTime());
		statement.executeUpdate();
	}
	
	public void insertUser(User user) {
		if (user == null) {
			return;
		}
		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = (Connection) cpds.getConnection();
			
			String sql = "insert users (username, password, email, sex, phone, introduce, is_admin)"
					+ "value(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(5, user.getPhone());
			statement.setString(6, user.getIntroduce());
			statement.executeUpdate();
			
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByName(String username) {
		if (username == null) {
			return null;
		}
		
		User user = null;
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = (Connection) cpds.getConnection();
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet= statement.executeQuery("select * from users where username='" + username + "'");
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setIntroduce(resultSet.getString("introduce"));
			}
			resultSet.close();
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public User getUserById(int id) {
		if (id <= 0) {
			return null;
		}
		
		User user = null;
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = (Connection) cpds.getConnection();
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet= statement.executeQuery("select * from users whereis name=" + id);
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setIntroduce(resultSet.getString("introduce"));
			}
			resultSet.close();
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = cpds.getConnection();
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users");
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setIntroduce(resultSet.getString("introduce"));
				users.add(user);
			}
			resultSet.close();
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
