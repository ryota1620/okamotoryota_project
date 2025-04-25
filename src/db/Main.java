package db;

import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     ProductManager manager = new ProductManager();
     Scanner scanner = new Scanner(System.in);

     while (true) {
         System.out.println("\n1: 商品追加, 2: 商品更新, 3: 商品削除, 0: 終了");
         System.out.print("操作を選んでください: ");
         String input = scanner.nextLine();

         switch (input) {
             case "1":
                 manager.addProduct();
                 break;
             case "2":
                 manager.updateProduct();
                 break;
             case "3":
                 manager.deleteProduct();
                 break;
             case "0":
                 System.out.println("終了します。");
                 return;
             default:
                 System.out.println("無効な選択です。");
         }
     }
 }
}
