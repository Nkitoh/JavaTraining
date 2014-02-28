package ex14_03;

public class Calculate {
	private int num = 0;

	public synchronized void add(int addNum) {
		num += addNum;
	}
	
	public synchronized int getNum() {
		return num;
	}
}
