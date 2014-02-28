package ex13_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testCountStringT() {
		int count;
		count = StringUtil.countChar("testtesttest", 't');
		
		assertEquals(count, 6);
	}

	public void testCountStringS() {
		int count;
		count = StringUtil.countChar("testtesttest", 's');
		
		assertEquals(count, 3);
	}
	
	public void testCountString0() {
		int count;
		count = StringUtil.countChar("testtesttest", 'f');
		
		assertEquals(count, 0);
	}
}
