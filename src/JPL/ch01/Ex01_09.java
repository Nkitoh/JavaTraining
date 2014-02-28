package ch01;

public class Ex01_09 {
	static final int ARRAY_INDEX_NUM = 10;

	public static void main(String[] args) {
		/** 値が50未満のフィボナッチ数列を表示する */
		int[] fib_series = new int[ARRAY_INDEX_NUM];
		int index ;

		fib_series[0] = 1;
		fib_series[1] = 1;

		index = 1;

		while (fib_series[index] < 50) {
			index++;
			fib_series[index] = fib_series[index - 2] + fib_series[index - 1];
		}

		for (int i = 0; i < fib_series.length; i++) {
			System.out.println(fib_series[i]);
		}
	}
}
