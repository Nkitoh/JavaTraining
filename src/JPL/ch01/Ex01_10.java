package ch01;

public class Ex01_10 {
	static final int ARRAY_INDEX_NUM = 10;

	public static void main(String[] args) {

		/** 値が50未満のフィボナッチ数列を表示する */
		Ex01_10_Fib[] fib_series = new Ex01_10_Fib[ARRAY_INDEX_NUM];
		int index;

		for (int i = 0; i < fib_series.length; i++) {
			fib_series[i] = new Ex01_10_Fib();
		}
		// フィボナッチ数列の0,1番目の値をセット
		fib_series[0].set_num(1);
		fib_series[1].set_num(1);

		index = 1;

		int next_fib;
		while (fib_series[index].get_num() < 50) {
			index++;

			next_fib = fib_series[index - 2].get_num()
					+ fib_series[index - 1].get_num();

			fib_series[index].set_num(next_fib);
		}

		for (int i = 0; i < fib_series.length; i++) {
			System.out.println("num:" + fib_series[i].get_num() + ",even:"
					+ fib_series[i].get_even());
		}
	}
}

class Ex01_10_Fib {
	private int fib_num;
	private boolean even;

	public void set_num(int x) {
		fib_num = x;

		if (fib_num % 2 == 0) {
			even = true;
		} else {
			even = false;
		}
	}

	public int get_num() {
		return fib_num;
	}

	public boolean get_even() {
		return even;
	}
}
