package ex14_06;

public class PrintTime implements Runnable {
	private int countSec = 0;
	private Runnable OneSecThread;
	private PrintTimeNsec[] printArray;
	public PrintTime(PrintTimeNsec ... printArray) {
		this.printArray = new PrintTimeNsec[printArray.length];
		for (int i = 0; i < printArray.length; i++)
			this.printArray[i] = printArray[i];
		new Thread(this).start();
	}

	synchronized void printOneSec() throws Exception {
		Thread.sleep(1000);
		countSec++;
		System.out.println(countSec);
		for (int i = 0; i < printArray.length; i++)
			printArray[i].accept(countSec);
	}

	public void run() {
		for (;;) {
			try {
				printOneSec();		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
