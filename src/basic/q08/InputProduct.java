package basic.q08;

import java.util.Scanner;

public class InputProduct {

	public static void main(String args[]) {
		java.util.Scanner scanner = new Scanner(System.in);
		System.out.print("商品名を入力してください：");
		String name = scanner.nextLine();
		System.out.print("価格を入力してください：");
		int price = scanner.nextInt();

		System.out.println("商品名は" + name + "です。価格は" + price + "円です。");
		scanner.close();

	}
}
