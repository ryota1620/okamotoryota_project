package task6;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductManager service = new ProductManager(scanner);

		while (true) {
			System.out.println("\n--メニュー--");
			System.out.println("1:商品追加");
			System.out.println("2:商品情報取得");
			System.out.println("3:商品検索");
			System.out.println("4:商品全て表示");
			System.out.println("5:商品削除");
			System.out.println("0:終了");
			System.out.print("\nメニューから操作を選択してください：");

			String input = scanner.nextLine();
			int choice;
			try {
				choice = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("無効な入力です。番号を入力してください。");
				continue;
			}

			try {
				switch (choice) {
				case 1 -> service.addProduct();
				case 2 -> service.getProductByName();
				case 3 -> service.searchProduct();
				case 4 -> service.displayAllProducts();
				case 5 -> service.deleteProduct();
				case 0 -> {
					System.out.println("終了します");
					return;
				}
				default -> System.out.println("無効な選択です。");
				}
			} catch (Exception e) {
				System.out.println("java.lang.Exception: " + e.getMessage());
			}
		}
	}
}
