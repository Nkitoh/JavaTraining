package ex14_02;


public class PrintServerTest {
	public static void main(String[] args) throws Exception{

		final int N = 3;
		PrintJob[] jobs = new PrintJob[N];
		PrintServer machine = new PrintServer();
		
		for (int i = 0 ; i < jobs.length; i++) {
			jobs[i] = new PrintJob(String.valueOf(i));
			Thread.sleep(1000);
			machine.print(jobs[i]);
		}
		
		machine.run();
	}
}
