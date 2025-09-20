package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {
	public List<Product> findAll() throws Exception {
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM products";

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setStock(rs.getInt("stock"));
				p.setCategoryId(rs.getInt("category_id"));
				list.add(p);
			}
		}
		return list;
	}

	public void insert(Product product) throws Exception {
		String sql = "INSERT INTO products(name, price, stock, category_id) VALUES(?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setInt(3, product.getStock());
			ps.setInt(4, product.getCategoryId());
			ps.executeUpdate();
		}
	}
}
