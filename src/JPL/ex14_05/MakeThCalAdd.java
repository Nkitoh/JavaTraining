package ex14_05;

public class MakeThCalAdd implements Runnable{
	final int Count;
	final int AddNum;
	
	MakeThCalAdd(int count, int add) {
		Count = count;
		AddNum = add;
	}
	
	public void run() {
		for (int i = 0 ;i < Count ; i++)
			Calculate.add(AddNum);
	}

}
