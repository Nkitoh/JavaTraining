package ch03_06;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test1() {
		Vehicle Benz = new Vehicle(new GasTank((char)120),"Benz", 120, 45,
				"A1", "A2", "A3");
		Vehicle Corolla = new Vehicle(new Battery((char)0),"Corolla", 40,
				70, "B", "B2", "B3");

		assertEquals(true, Benz.start().equals("Start!"));
		assertEquals(true, Corolla.start().equals("No Enegy!"));
	}
	
	@Test
	public void test2() {
		Vehicle Benz = new Vehicle(new GasTank((char)0),"Benz", 120, 45,
				"A1", "A2", "A3");
		Vehicle Corolla = new Vehicle(new Battery((char)20),"Corolla", 40,
				70, "B", "B2", "B3");

		assertEquals(true, Benz.start().equals("No Enegy!"));
		assertEquals(true, Corolla.start().equals("Start!"));
	}

}
