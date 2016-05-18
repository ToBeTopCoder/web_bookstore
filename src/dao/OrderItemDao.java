package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DataSourceUtils;

/*
 * 订单中条目类操作类
 * @author: luoxn28
 * @date: 2016.5.18
 */
public class OrderItemDao {
	/*
	 * 往订单条目orderitem表中插入一条订单条目
	 * @param OrderItem
	 * @return void
	 */
	public void addOrderItem(OrderItem orderItem) {
		try {
			Connection connection = DataSourceUtils.getConnection();
			String sql = "INSERT orderitem (order_id, product_id, buynum)"
					+ "(?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, orderItem.getOrderId());
			statement.setInt(2, orderItem.getProductId());
			statement.setInt(3, orderItem.getBuyNum());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
