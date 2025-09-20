package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO {
	public List<Category> findAll() throws Exception {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT * FROM categories";

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Category c = new Category(rs.getInt("id"), rs.getString("name"));
				list.add(c);
			}
		}
		return list;
	}
}
