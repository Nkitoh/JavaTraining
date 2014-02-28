package ch04_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortHarnessTest {

	@Test
	public void testDouble() {
		Double[] testData = {
			0.3, 1.3e-2, 7.9, 3.17
		};
		SortHarness bsort = new SortHarness();
		bsort.sort(testData, new SimpleSortHarness() );
		
		assertEquals(true, bsort.isSorted());
		
	}
	
	@Test
	public void testInteger() {
		Integer[] testData = {
			4, -2, 90, 7
		};
		SortHarness bsort = new SortHarness();
		bsort.sort(testData, new SimpleSortHarness() );
		assertEquals(true, bsort.isSorted());
		
	}
	
	@Test
	public void testString() {
		String[] testData = {
			"TEST", "APPLE", "BOOK", "JAVA"
		};
		SortHarness bsort = new SortHarness();
		bsort.sort(testData, new SimpleSortHarness() );
		assertEquals(true, bsort.isSorted());
		
	}

}
