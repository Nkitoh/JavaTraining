package ch01;

public class Ex01_03 {

	public static void main(String[] args) {
		/**値が50未満のフィボナッチ数列を表示する*/
		int lo = 1,
		 	hi = 1;
		System.out.println("----Fibonacci----");
		System.out.println("        "+lo);
		while(hi < 50){
			System.out.println("        "+hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
