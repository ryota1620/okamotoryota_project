package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.entity.Category;

public class CategoryDAO {

	private final String URL = "jdbc:mysql://localhost:3306/product_management";;
	private final String USER = "root";
	private final String PASS = "Ryon1620";

	public void insert(Category category) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
			String sql = "INSERT INTO categories (id, category_name) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getId());
			ps.setString(2, category.getName());
			ps.executeUpdate();
		}
	}
}