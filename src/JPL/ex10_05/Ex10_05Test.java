package ex10_05;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ex10_05Test {

	@Test
	public void test1() {
		assertEquals(Ex10_05.interval("abcdefg", 1, 5), "bcdef");
	}
	
	@Test
	public void test2() {
		assertEquals(Ex10_05.interval("abcdefg", 0, 0), "a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test3() {
		assertEquals(Ex10_05.interval("abcdefg", -1, 0), "a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test4() {
		assertEquals(Ex10_05.interval("abcdefg", 0, -3), "a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		assertEquals(Ex10_05.interval("abcdefg", 3, 2), "a");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test6() {
		assertEquals(Ex10_05.interval("abcdefg",2 , 10), "a");
	}

}
