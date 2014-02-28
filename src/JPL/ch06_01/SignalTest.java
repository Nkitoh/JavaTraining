package ch06_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class SignalTest {

	@Test
	public void test() {
		Signal[] actualSignal = Signal.values();
		assertEquals(true, actualSignal[0].equals(Signal.valueOf("RED")));
		assertEquals(true, actualSignal[1].equals(Signal.valueOf("YELLOW")));
		assertEquals(true, actualSignal[2].equals(Signal.valueOf("GREEN")));
	}

}
