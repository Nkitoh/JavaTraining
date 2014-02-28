package ch06_04;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignalTest {

	@Test
	public void testRed() {
		assertEquals(true,Signal.getColor(Signal.RED).toString().equals("RED"));
	}
	
	public void testYellow() {
		assertEquals(true,Signal.getColor(Signal.YELLOW).toString().equals("YELLOW"));
	}
	
	public void testGreen() {
		assertEquals(true,Signal.getColor(Signal.GREEN).toString().equals("GREEN"));
	}

}