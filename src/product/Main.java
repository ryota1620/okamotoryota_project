package product;

public class Main {
	public static void main(String[] args) {
		ProductManager manager = new ProductManager();

		manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
		manager.addProduct(new Product(2, "ソファ", 30000, 5));
		manager.addProduct(new Product(3, "米", 2000, 3));
		manager.addProduct(new Product(4, "小説", 1500, 4));
		manager.addProduct(new Product(5, "Tシャツ", 1500, 5));

		System.out.println("--商品名「ソファ」の情報と割引率30%の情報を表示する--");
		DiscountedProduct sofa = new DiscountedProduct(2, "ソファ", 30000, 5, 0.3);
		System.out.println(sofa);

		System.out.println("--商品名「Tシャツ」を検索して表示する--");
		for (Product p : manager.search("Tシャツ")) {
			System.out.println(p);
		}
	}
}
