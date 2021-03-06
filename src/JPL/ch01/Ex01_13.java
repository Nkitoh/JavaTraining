package ch01;

public class Ex01_13 {
	static final int MAX_INDEX = 9;

	public static void main(String[] args) {

		int lo = 1;
		int hi = 1;
		String mark;

		// ex13:printfで表示
		System.out.printf("1: %3d %n", lo);

		for (int i = 2; i <= MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			System.out.printf("%d: %3d %s %n", i, hi, mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
