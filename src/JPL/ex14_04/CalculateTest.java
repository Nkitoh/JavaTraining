package ex14_04;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	@Test
	public void testCalculateThread4Count1000() throws Exception{
		final int NumThread = 4;
		final int Count = 1000;
		
		Thread[] threadArray = new Thread[NumThread];
		
		Calculate.init();
		
		for (int i = 0; i < NumThread; i++) {
			threadArray[i] = new Thread(new MakeThCalAdd(Count, 1));
			threadArray[i].start();
		}
		
		for (int i = 0; i < NumThread; i++)
			threadArray[i].join();
		
		assertTrue(Calculate.getNum() == NumThread * Count);
	}
	
	@Test
	public void testCalculateThread10Count1000000() throws Exception{
		final int NumThread = 10;
		final int Count = 1000000;
		
		Thread[] threadArray = new Thread[NumThread];
		
		Calculate.init();
		
		for (int i = 0; i < NumThread; i++) {
			threadArray[i] = new Thread(new MakeThCalAdd(Count, 1));
			threadArray[i].start();
		}
		
		for (int i = 0; i < NumThread; i++)
			threadArray[i].join();
		assertTrue(Calculate.getNum() == NumThread * Count);
	}

}
