package ex14_03;

public class MakeThCalAdd implements Runnable{
	private Calculate cal;
	final int Count;
	final int AddNum;
	
	MakeThCalAdd(Calculate inputCal, int count, int add) {
		cal = inputCal;
		Count = count;
		AddNum = add;
	}
	
	public void run() {
		for (int i = 0 ;i < Count ; i++)
			cal.add(AddNum);
	}

}
