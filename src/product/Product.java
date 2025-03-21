package product;

public class Product {
	private int id;
	private String name;
	private int price;
	private int stock;

	public Product(int id, String name, int price, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public int getid() {
		return id;
	}

	public String getname() {
		return name;
	}

	public int getprice() {
		return price;
	}

	public int getstock() {
		return stock;
	}

	public void setid(int id) {
		this.id = id;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public void setstock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product: id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock;
	}
}