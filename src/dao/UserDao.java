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
	public void addUser(User user) {
		try {
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据用户名获取数据库中该用户记录
	 * @param username
	 * @return User 未找到时返回null
	 */
	public User getUser(String username) {
		User user = null;
		
		try {
			Connection connection = DataSourceUtils.getConnection();
			String sql = "SELECT * from user where username='" + username + "'";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setGender(resultSet.getString("gender"));
				user.setEmail(resultSet.getString("email"));
				user.setPhone(resultSet.getString("phone"));
				user.setIntroduce(resultSet.getString("introduce"));
				user.setActiveCode(resultSet.getString("activeCode"));
				user.setState(resultSet.getInt("state"));
				user.setRole(resultSet.getString("role"));
				user.setRegistTime(resultSet.getString("registTime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
