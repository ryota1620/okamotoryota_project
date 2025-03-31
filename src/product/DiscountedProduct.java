package product;

public class DiscountedProduct extends Product {
	private double discountRate;

	public DiscountedProduct(int id, String name, int price, int stock, double discountRate) {
		super(id, name, price, stock);
		this.discountRate = discountRate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public int calculateDiscountedPrice() {
		return (int) (getprice() * (1 - discountRate));
	}

	@Override
	public String toString() {
		return super.toString() + ", 割引率=" + discountRate + ", 割引後価格=" + calculateDiscountedPrice();
	}
}
