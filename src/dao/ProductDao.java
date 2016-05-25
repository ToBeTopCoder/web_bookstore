package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
					+ "value(?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			statement.setString(3, product.getCategory());
			statement.setInt(4, product.getNum());
			statement.setString(5, product.getImgurl());
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
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	/*
	 * 更新数据表中producct余量
	 * @param id: 商品id，num:商品余量
	 * @return void
	 */
	public void updateProductNum(int id, int num) {
		try {
			Connection connection = DataSourceUtils.getConnection();
			String sql = "UPDATE products set num=" + num + " where id=" + id;
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据商品种类获取商品
	 * @param category 商品种类
	 * @return Set 该种类商品集合
	 */
	public Set<Product> getProductByCategory(String category) {
		Set<Product> set = null;
		
		try {
			String sql = "SELECT * FROM products";
			Connection connection = DataSourceUtils.getConnection();
			Statement statement = connection.createStatement();

			if (!category.equals("全部商品")) {
				sql += " where category='" + category + "'";
			}
			set = new LinkedHashSet<Product>();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
				set.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}
	
	/*
	 * 根据名称查找商品，未找到返回null
	 * @param bookName 商品名
	 * @return 包含该商品名的商品集合
	 */
	public Set<Product> getProductBySearchName(String bookName) {
		Set<Product> set = null;
		
		try {
			// 使用通配符，效率较低
			String sql = "SELECT * FROM products WHERE name LIKE '%" + bookName + "%'";
			Connection connection = DataSourceUtils.getConnection();
			Statement statement = connection.createStatement();

			set = new LinkedHashSet<Product>();
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
				set.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return set;
	}
	
	/*
	 * 获取所有商品
	 * @param void
	 * @return 所有商品List
	 */
	public List<Product> getAllProdut() {
		List<Product> lists = null;
		
		try {
			String sql = "SELECT * FROM products";
			Connection connection = DataSourceUtils.getConnection();
			Statement statement = connection.createStatement();

			lists = new ArrayList<Product>();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setPrice(resultSet.getDouble("price"));
				product.setCategory(resultSet.getString("category"));
				product.setNum(resultSet.getInt("num"));
				product.setImgurl(resultSet.getString("imgurl"));
				product.setDescription(resultSet.getString("description"));
				lists.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lists;
	}
}
