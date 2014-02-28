package ch01;

public class Ex01_05 {

	public static void main(String[] args) {
		System.out.println(PrintWord.MORNING);
		System.out.println(PrintWord.HELLO);
		System.out.println(PrintWord.EVNING);
	}
}

class PrintWord {
	static final String MORNING = "GOOD MORNING";
	static final String HELLO = "Hello!!";
	static final String EVNING = "GOOD EVNING";
}
