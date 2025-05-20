package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
    public List<CategoryBean> findAll() throws SQLException {
        List<CategoryBean> list = new ArrayList<>();
        String sql = "SELECT id, category_name FROM categories";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                CategoryBean category = new CategoryBean();
                category.setCategoryId(rs.getInt("id"));
                category.setCategoryName(rs.getString("category_name"));
                list.add(category);
            }
        }
        return list;
    }
}
