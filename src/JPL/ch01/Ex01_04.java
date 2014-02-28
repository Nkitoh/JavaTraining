package ch01;

public class Ex01_04 {

	static final int MAX = 9;
	static final int POW = 2;

	public static void main(String[] args) {
		/** 1~MAXまでの平方表を表示する */
		int num;
		System.out.println("----Square Number----");
		System.out.println("    num     square ");

		for (num = 1; num <= MAX; num++) {
			System.out.println("    " + num + "          "
					+ (int) Math.pow(num, POW));

		}
	}
}
