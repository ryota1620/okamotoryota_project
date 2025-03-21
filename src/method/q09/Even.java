package method.q09;

public class Even {
	public static boolean odd(int number) {
		return number % 2 != 0;
	}

	public static boolean even(int number) {
		return number % 2 == 0;
	}

	public static void main(String[] args) {
		int[] numbers = { 1 };

		for (int number : numbers) {
			if (odd(number)) {
				System.out.println(number + " は奇数です。");
			} else if (even(number)) {
				System.out.println(number + " は偶数です。");
			}
		}
	}
}