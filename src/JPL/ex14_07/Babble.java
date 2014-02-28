package ex14_07;

public class Babble extends Thread{
	static boolean doYield;
	static int howOften;
	private String word;
	
	Babble(String whatToSay) {
		word = whatToSay;
	}
	
	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield)
				Thread.yield();
		}
	}
	/*?true 2 Did DidNot
	1回目:
	Did
	DidNot
	Did
	DidNot
	2回目:
	Did
	Did
	DidNot
	DidNot
	3回目:
	Did
	DidNot
	DidNot
	Did
	*/
	public static void main(String[] args) {
		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);
	
		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();
	}
}
