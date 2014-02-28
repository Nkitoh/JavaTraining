package ex13_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtil2Test {

	@Test
	public void testCountStringTest() {
		int count;
		count = StringUtil2.countStr("testtesttest", "test");
		
		assertEquals(count, 3);
	}

	public void testCountStringTt() {
		int count;
		count = StringUtil2.countStr("testtesttest", "tt");
		
		assertEquals(count, 2);
	}
	
	public void testCountString0() {
		int count;
		count = StringUtil2.countStr("testtesttest", "find");
		
		assertEquals(count, 0);
	}
}

