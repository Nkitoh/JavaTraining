package ch01;

public class Ex01_06 {

	public static void main(String[] args) {
		/** 値が50未満のフィボナッチ数列を表示する */
		int lo = 1, hi = 1;
		System.out.println(TITLE.Fib); ////練習問題1-3との相違点
		System.out.println("        " + lo);
		while (hi < 50) {
			System.out.println("        " + hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}

class TITLE{
	static final String Fib = "Fibonacci";
}