package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DataSourceUtils;

/*
 * 商品操作类
 * @author luoxn28
 * @date 2016.5.15
 */
public class ProductDao {
	/*
	 * 往商品products表中插入一条商品记录
	 * @param Product
	 * @return void
	 */
	public void addProduct(Product product) {
		try {
			Connection connection = DataSourceUtils.getConnection();
			String sql = "INSERT products (name, price, category, num, imgurl, description)"
					+ "(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getCategory());
			statement.setInt(4, product.getNum());
			statement.setString(5, product.getImgrul());
			statement.setString(6, product.getDescription());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据商品id查找该商品信息
	 * @param id: 商品id
	 * @return Product，未找到时返回null
	 */
	public Product getProduct(int id) {
		Product product = null;

		try {
			Connection connection = DataSourceUtils.getConnection();
			String sql = "SELECT * from products where id=" + id;
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				product = new Product();
				product.setId(id);
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgrul(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
}
