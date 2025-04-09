package task6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductManager {
	private Map<Integer, Product> productMap = new HashMap<>();
	private Scanner scanner;

	public ProductManager(Scanner scanner) {
		this.scanner = scanner;
	}

	public void addProduct() throws Exception {
		System.out.print("商品IDを入力してください：");
		int id = Integer.parseInt(scanner.nextLine());

		System.out.print("商品名を入力してください：");
		String name = scanner.nextLine();

		System.out.print("価格を入力してください：");
		int price = Integer.parseInt(scanner.nextLine());

		System.out.print("在庫数を入力してください：");
		int stock = Integer.parseInt(scanner.nextLine());

		Product product = new Product(id, name, price, stock);
		productMap.put(id, product);
		System.out.println(product + "を登録しました。");
	}

	public void getProductByName() {
		System.out.print("商品情報を取得する商品名を入力してください：");
		String name = scanner.nextLine();
		for (Product p : productMap.values()) {
			if (p.getName().equals(name)) {
				System.out.println("取得した商品は、" + p + "です。");
				return;
			}
		}
		System.out.println("該当する商品が見つかりません。");
	}

	public void searchProduct() {
		System.out.print("検索する商品名を入力してください：");
		String keyword = scanner.nextLine();
		boolean found = false;
		for (Product p : productMap.values()) {
			if (p.getName().contains(keyword)) {
				System.out.println(p);
				found = true;
			}
		}
		if (!found) {
			System.out.println("該当する商品が見つかりません。");
		}
	}

	public void displayAllProducts() {
		if (productMap.isEmpty()) {
			System.out.println("商品が登録されていません。");
			return;
		}

		System.out.println("商品を全て表示します");
		for (Product p : productMap.values()) {
			System.out.println(p);
		}
	}

	public void deleteProduct() {
		System.out.print("削除する商品のIDを入力してください：");
		int id = Integer.parseInt(scanner.nextLine());
		if (productMap.remove(id) != null) {
			System.out.println("商品IDが" + id + "の商品を削除しました");
		} else {
			System.out.println("該当する商品が見つかりません。");
		}
	}
}
