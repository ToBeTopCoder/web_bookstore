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
 * 订单操作类
 * @author: luoxn28
 * @date: 2016.5.18
 */
public class OrderDao {
	/*
	 * 往订单orders表中插入一条订单记录
	 * @param Order
	 * @return void
	 */
	public void addOrder(Order order) {
		try {
			Connection connection = DataSourceUtils.getConnection();
			String sql = "INSERT orders (id, money, receiveAddress, receiveName, receivePhone, paystate, orderTime, user_id)"
					+ "value(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, order.getId());
			statement.setDouble(2, order.getMoney());
			statement.setString(3, order.getReceiceAddress());
			statement.setString(4, order.getRecviceName());
			statement.setString(5, order.getRecvicePhone());
			statement.setDouble(6, order.getPaystate());
			statement.setString(7, order.getOrderTime());
			statement.setInt(8, order.getUserId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
