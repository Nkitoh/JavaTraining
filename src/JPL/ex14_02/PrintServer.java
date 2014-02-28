package ex14_02;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private Thread printThread ;

	public PrintServer() {
		printThread = new Thread(this);
		printThread.start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	public void run() {
		if (printThread.equals(Thread.currentThread()))
			System.err.println("Run is not used");
		for (;;)
			try {
				realPrint(requests.remove());
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
	}

	private void realPrint(PrintJob job) {
			System.out.println(job.Work());
	}

}
