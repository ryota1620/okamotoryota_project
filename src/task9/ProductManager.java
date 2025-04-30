package task9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private static class UpdateInfo {
        int id;
        int price;
        int stock;

        UpdateInfo(int id, int price, int stock) {
            this.id = id;
            this.price = price;
            this.stock = stock;
        }
    }

    public void updateProducts() {
        Scanner scanner = new Scanner(System.in);
        List<UpdateInfo> updateList = new ArrayList<>();
        int updateCount = 2;

        try (Connection conn = ProductDB.getConnection()) {
            conn.setAutoCommit(false);

            String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                int successCount = 0;

                for (int i = 1; i <= updateCount; i++) {
                    System.out.println("--商品の価格と在庫を更新" + i + "--");
                    System.out.print("商品IDを入力してください：");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("価格を入力してください：");
                    int price = Integer.parseInt(scanner.nextLine());

                    System.out.print("在庫数を入力してください：");
                    int stock = Integer.parseInt(scanner.nextLine());

                    pstmt.setInt(1, price);
                    pstmt.setInt(2, stock);
                    pstmt.setInt(3, id);

                    int result = pstmt.executeUpdate();

                    if (result == 1) {
                        successCount++;
                        updateList.add(new UpdateInfo(id, price, stock));
                    } else {
                        throw new SQLException("商品ID: " + id + " の更新失敗");
                    }
                }

                conn.commit();
                System.out.println("コミット成功");
                System.out.println("更新成功件数：" + successCount + "件");

                for (int i = 0; i < updateList.size(); i++) {
                    UpdateInfo info = updateList.get(i);
                    System.out.println("\n更新内容" + (i + 1) + "：");
                    System.out.println("商品ID: " + info.id + "、価格: " + info.price + "、在庫数: " + info.stock);
                }

            } catch (Exception e) {
                conn.rollback();
                System.out.println(updateCount + "件全ての更新に失敗しました。");
                System.out.println("更新成功件数：" + updateList.size() + "件");
                System.out.println("ロールバックしました。");
            }

        } catch (Exception e) {
            System.out.println("DB接続エラー: " + e.getMessage());
        }
    }
}

