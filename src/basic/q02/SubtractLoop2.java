package basic.q02;

class SubtractLoop2 {
	public static void main(String[] args) {
		int count = 100;

		do {
			System.out.println(count);
			count = count - 1;
		} while (count >= 0);
	}
}