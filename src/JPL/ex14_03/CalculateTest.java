package ex14_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	@Test
	public void testCalculateThread4Count1000() throws Exception{
		Calculate testCal = new Calculate();
		final int NumThread = 4;
		final int Count = 1000;
		
		Thread[] threadArray = new Thread[NumThread];
		
		for (int i = 0; i < NumThread; i++) {
			threadArray[i] = new Thread(new MakeThCalAdd(testCal, Count, 1));
			threadArray[i].start();
		}
		
		for (int i = 0; i < NumThread; i++)
			threadArray[i].join();
		
		assertTrue(testCal.getNum() == NumThread * Count);
	}
	
	@Test
	public void testCalculateThread10Count1000000() throws Exception{
		Calculate testCal = new Calculate();
		final int NumThread = 10;
		final int Count = 1000000;
		
		Thread[] threadArray = new Thread[NumThread];
		
		for (int i = 0; i < NumThread; i++) {
			threadArray[i] = new Thread(new MakeThCalAdd(testCal, Count, 1));
			threadArray[i].start();
		}
		
		for (int i = 0; i < NumThread; i++)
			threadArray[i].join();
		
		assertTrue(testCal.getNum() == NumThread * Count);
	}

}
