package ex14_05;

public class MakeThCalSub implements Runnable{
	final int Count;
	final int SubNum;
	
	MakeThCalSub(int count, int sub) {
		Count = count;
		SubNum = sub;
	}
	
	public void run() {
		for (int i = 0 ;i < Count ; i++)
			Calculate.sub(SubNum);
	}

}
