package ch06_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeekTest {

	@Test
	public void test() {
		Week[] actualWeek = Week.values();

		assertEquals(true, actualWeek[0].equals(Week.valueOf("MONDAY")));
		assertEquals(true, actualWeek[1].equals(Week.valueOf("TUESDAY")));
		assertEquals(true, actualWeek[2].equals(Week.valueOf("WEDNESDAY")));
		assertEquals(true, actualWeek[3].equals(Week.valueOf("THURSDAY")));
		assertEquals(true, actualWeek[4].equals(Week.valueOf("FRIDAY")));
		assertEquals(true, actualWeek[5].equals(Week.valueOf("SATURDAY")));
		assertEquals(true, actualWeek[6].equals(Week.valueOf("SUNDAY")));
	}

}
