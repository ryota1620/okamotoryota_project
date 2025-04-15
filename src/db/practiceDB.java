package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class practiceDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/product_management";
        String user = "root";
        String password = "Ryon1620";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("DB接続成功");

            String sql = "SELECT * FROM products";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("--productsテーブルの全ての商品情報を表示--");

            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println("price: " + rs.getInt("price"));
                System.out.println("stock: " + rs.getInt("stock"));
                System.out.println("category_id: " + rs.getInt("category_id"));
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("DB接続失敗");
            e.printStackTrace();
        }
    }
}
