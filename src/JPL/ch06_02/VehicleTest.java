package ch06_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testLeft() {
		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Benz.TurnDirection(Turn.LEFT);
		assertEquals(true,Benz.get_angle() == 135);
	}
	
	@Test
	public void testRight() {
		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Benz.TurnDirection(Turn.RIGHT);
		assertEquals(true,Benz.get_angle() == -45);
	}

}
