package method.q07;

public class SumNumbers2 {
	public static void main(String[] args) {
		int x = 5;
		double y = 3.3;
		int sum = calculateSum(x, y);
		System.out.println("第一引数（整数）:" + x);
		System.out.println("第二引数（実数）:" + y);
		System.out.println("加算結果:" + sum);
	}

	public static int calculateSum(int x, double y) {
		return (int) (x + y);
	}
}