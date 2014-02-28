package ch01;

public class Ex01_12 {
	static final int ARRAY_INDEX_NUM = 10;

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String[] print_fib = new String[ARRAY_INDEX_NUM];

		print_fib[0] = Integer.toString(1);
		print_fib[0] += ":";
		print_fib[0] += Integer.toString(lo);

		for (int i = 2; i <= print_fib.length; i++) {
			print_fib[i - 1] = Integer.toString(i);
			print_fib[i - 1] += ":";
			print_fib[i - 1] += Integer.toString(hi);

			if (hi % 2 == 0) {
				print_fib[i - 1] += " *";
			}
			hi = lo + hi;
			lo = hi - lo;
		}

		for (int i = 0; i < print_fib.length; i++) {
			System.out.println(print_fib[i]);
		}
	}
}