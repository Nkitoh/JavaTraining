package ex14_04;

public class Calculate {
	private static int num = 0;

	public synchronized static void init() {
		num = 0;
	}
	
	public synchronized static void add(int addNum) {
		num += addNum;
	}
	
	public synchronized static int getNum() {
		return num;
	}
}
