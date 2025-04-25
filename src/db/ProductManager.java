package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductManager {
    private final Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        try (Connection conn = ProductDB.getConnection()) {
            System.out.println("--商品を登録--");
            System.out.print("商品名を入力してください：");
            String name = scanner.nextLine();

            System.out.print("価格を入力してください：");
            int price = Integer.parseInt(scanner.nextLine());

            System.out.print("在庫数を入力してください：");
            int stock = Integer.parseInt(scanner.nextLine());

            System.out.print("カテゴリIDを入力してください：");
            int categoryId = Integer.parseInt(scanner.nextLine());

            String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, stock);
            ps.setInt(4, categoryId);

            int rows = ps.executeUpdate();
            System.out.println("登録成功件数：" + rows + "件");
            if (rows > 0) {
                System.out.println("登録内容：");
                System.out.printf("商品名：%s，価格：%d，在庫数：%d，カテゴリID：%d%n", name, price, stock, categoryId);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("登録に失敗しました: " + e.getMessage());
        }
    }

    public void updateProduct() {
        try (Connection conn = ProductDB.getConnection()) {
            System.out.println("--商品の価格と在庫を更新--");
            System.out.print("商品IDを入力してください：");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("価格を入力してください：");
            int price = Integer.parseInt(scanner.nextLine());

            System.out.print("在庫数を入力してください：");
            int stock = Integer.parseInt(scanner.nextLine());

            String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, price);
            ps.setInt(2, stock);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            System.out.println("更新成功件数：" + rows + "件");
            if (rows > 0) {
                System.out.printf("更新内容：商品ID：%d，価格：%d，在庫数：%d%n", id, price, stock);
            } else {
                System.out.println("更新失敗");
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("更新エラー: " + e.getMessage());
        }
    }

    public void deleteProduct() {
        try (Connection conn = ProductDB.getConnection()) {
            System.out.println("--商品の削除--");
            System.out.print("商品IDを入力してください：");
            int id = Integer.parseInt(scanner.nextLine());

            String sql = "DELETE FROM products WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println("削除成功件数：" + rows + "件");
            if (rows > 0) {
                System.out.printf("商品ID %d を削除しました。%n", id);
            } else {
                System.out.println("削除失敗");
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("削除エラー: " + e.getMessage());
        }
    }
}
