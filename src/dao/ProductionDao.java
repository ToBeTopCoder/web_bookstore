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

public class ProductionDao {
	public static DataSource ds = null;
	
	public void insertProduction(Production production) {
		if (production == null) {
			return;
		}
		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = (Connection) cpds.getConnection();
			
			String sql = "insert products (name, price, category, pnum, imgurl, description)"
					+ "value(?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			
			statement.setString(1, production.getName());
			statement.setDouble(2, production.getPrice());
			statement.setString(3, production.getCategory());
			statement.setInt(4, production.getPnum());
			statement.setString(5, production.getImgurl());
			statement.setString(6, production.getDescription());
			statement.executeUpdate();
			
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Production getProductionByName(String name) {
		if (name == null) {
			return null;
		}
		
		Production production = null;
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = cpds.getConnection();
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from products where name ='" + name + "'");
			if (resultSet.next()) {
				production = new Production();
				production.setId(resultSet.getInt("id"));
				production.setName(resultSet.getString("name"));
				production.setPrice(resultSet.getDouble("price"));
				production.setCategory(resultSet.getString("category"));
				production.setPnum(resultSet.getInt("pnum"));
				production.setDescript(resultSet.getString("description"));
			}
			resultSet.close();
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return production;
	}
	
	public List<Production> getAllProduction() {
		List<Production> productions = new ArrayList<Production>();
		
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource();
			Connection connection = cpds.getConnection();
			
			Statement statement = (Statement) connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from products");
			while (resultSet.next()) {
				Production production = new Production();
				production.setId(resultSet.getInt("id"));
				production.setName(resultSet.getString("name"));
				production.setPrice(resultSet.getDouble("price"));
				production.setCategory(resultSet.getString("category"));
				production.setPnum(resultSet.getInt("pnum"));
				production.setDescript(resultSet.getString("description"));
				productions.add(production);
			}
			resultSet.close();
			statement.close();
			connection.close();
			cpds.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productions;
	}
}
