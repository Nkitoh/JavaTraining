package ex14_06;

public class PrintTimeNsec implements Runnable {
	private int countSec = 0;
	private int flagSec = 0;
	final private int N;
	final private String message;
	public PrintTimeNsec(int N, String message) {
		this.N = N;
		this.message = message;
		new Thread(this).start();
	}

	synchronized void accept(int sec) {
		countSec = sec;
		//System.out.println("accept" + countSec);
		notifyAll();
	}

	synchronized void printMessage(int N, String message) throws Exception {
		
		while (countSec % N != 0 || countSec == 0)
			wait();
		if (flagSec != countSec)
			System.out.println(message);
		flagSec = countSec;
	}

	public void run() {
		for (;;) {
			try {
				printMessage(this.N, this.message);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
