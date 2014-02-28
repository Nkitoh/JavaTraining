package ex14_05;

public class Calculate {
	private static int num = 0;

	public static void init() {
		synchronized(Calculate.class) {
			num = 0;
		}
	}
	
	public static void add(int addNum) {
		synchronized(Calculate.class) {
			num += addNum;
		}
	}
	
	public static void sub(int subNum) {
		synchronized(Calculate.class) {
			num -= subNum;
		}
	}
	
	public static int getNum() {
		synchronized(Calculate.class) {
			return num;
		}
	}
}
