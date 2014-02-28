package ch06_05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignalTest {

	@Test
	public void testRed() {
		assertEquals(true,Signal.RED.getColor().toString().equals("RED"));
	}
	
	@Test
	public void testYellow() {
		assertEquals(true,Signal.YELLOW.getColor().toString().equals("YELLOW"));
	}
	
	@Test
	public void testGreen() {
		assertEquals(true,Signal.GREEN.getColor().toString().equals("GREEN"));
	}

}
