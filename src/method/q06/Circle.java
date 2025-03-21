package method.q06;

public class Circle {
	public static void main(String[] args) {
		double x = 5.0, y = 3.14;
		double ans = getCircleArea(x, y);
		System.out.println("半径:" + x);
		System.out.println("円の面積:" + ans);
	}

	public static double getCircleArea(double x, double y) {
		return x * x * y;
	}
}