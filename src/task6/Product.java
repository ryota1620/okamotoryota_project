package task6;

public class Product {
	private int id;
	private String name;
	private int price;
	private int stock;

	public Product(int id, String name, int price, int stock) throws Exception {
		if (name == null || name.trim().isEmpty()) {
			throw new Exception("無効な入力です。商品名を正しく入力してください。");
		}
		if (price < 0) {
			throw new Exception("無効な入力です。価格を正しく入力してください。");
		}
		if (stock < 0) {
			throw new Exception("無効な入力です。在庫数を正しく入力してください。");
		}

		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	@Override
	public String toString() {
		return String.format("Product: id=%d, name=%s, price=%d, stock=%d", id, name, price, stock);
	}
}
