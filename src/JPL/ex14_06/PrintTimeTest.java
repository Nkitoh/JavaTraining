package ex14_06;

public class PrintTimeTest {
	public static void main(String[] args) {
		
		Runnable printTimeTest = new PrintTime(new PrintTimeNsec(15,"15Sec"), new PrintTimeNsec(7,"7Sec"));
	}

}
