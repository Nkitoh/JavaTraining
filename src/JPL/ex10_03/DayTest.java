package ex10_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class DayTest {

	@Test
	public void testIfMonday() {
		assertEquals(true, Day.workUsingIf(Week.MONDAY));
	}
	
	@Test
	public void testIfTuesday() {
		assertEquals(true, Day.workUsingIf(Week.TUESDAY));
	}
	
	@Test
	public void testIfWednesday() {
		assertEquals(true, Day.workUsingIf(Week.WEDNESDAY));
	}
	
	@Test
	public void testIfThursday() {
		assertEquals(true, Day.workUsingIf(Week.THURSDAY));
	}
	
	@Test
	public void testIfFriday() {
		assertEquals(true, Day.workUsingIf(Week.FRIDAY));
	}
	
	@Test
	public void testIfSaturday() {
		assertEquals(false, Day.workUsingIf(Week.SATURDAY));
	}
	
	@Test
	public void testIfSunday() {
		assertEquals(false, Day.workUsingIf(Week.SUNDAY));
	}
	
	
	@Test
	public void testSwitchMonday() {
		assertEquals(true, Day.workUsingSwitch(Week.MONDAY));
	}
	
	@Test
	public void testSwitchTuesday() {
		assertEquals(true, Day.workUsingSwitch(Week.TUESDAY));
	}
	
	@Test
	public void testSwitchWednesday() {
		assertEquals(true, Day.workUsingSwitch(Week.WEDNESDAY));
	}
	
	@Test
	public void testSwitchThursday() {
		assertEquals(true, Day.workUsingSwitch(Week.THURSDAY));
	}
	
	@Test
	public void testSwitchFriday() {
		assertEquals(true, Day.workUsingSwitch(Week.FRIDAY));
	}
	
	@Test
	public void testSwitchSaturday() {
		assertEquals(false, Day.workUsingSwitch(Week.SATURDAY));
	}
	
	@Test
	public void testSwitchSunday() {
		assertEquals(false, Day.workUsingSwitch(Week.SUNDAY));
	}

}
