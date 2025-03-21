package method.q04;

public class SumNumbers {
	public static void main(String[] args) {
		int x = 3, y = 2;
		int sum = calculateSum(x, y);
		System.out.println("第一引数:" + x);
		System.out.println("第二引数:" + y);
		System.out.println("加算結果:" + sum);
	}

	public static int calculateSum(int x, int y) {
		return x + y;
	}
}