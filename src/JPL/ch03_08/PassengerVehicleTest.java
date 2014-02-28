package ch03_08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void test_clone() {
		PassengerVehicle Benz = new PassengerVehicle("Benz", 4, 2, 120, 45,
				"A1", "A2", "A3");
		PassengerVehicle Benz2 = Benz.clone();
		
		System.out.println(Benz.toString());
		System.out.println(Benz2.toString());
		
		assertEquals(true, Benz.getCarName().equals(Benz2.getCarName()));
		assertEquals(true, Benz.getSeatNum() == Benz2.getSeatNum());
		assertEquals(true, Benz.getPassengerNum() == Benz2.getPassengerNum());
		assertEquals(true, Benz.getSpeed() == Benz2.getSpeed());
		assertEquals(true, Benz.getAngle() == Benz2.getAngle());
		for (int num_owner = 0; num_owner < Benz.getOwner().size(); num_owner++) {
			assertEquals(true, Benz.getOwner().get(num_owner).equals( Benz2.getOwner().get(num_owner)));
			
		}
		assertEquals(false,Benz.getIdNum() == Benz2.getIdNum());
	
	}
	
	@Test
	public void test_clone_change() {
		PassengerVehicle Benz = new PassengerVehicle("Benz", 4, 2, 120, 45,
				"A1", "A2", "A3");
		PassengerVehicle Benz2 = Benz.clone();
		Benz.setPassengerNum(1);
		
		System.out.println(Benz.toString());
		System.out.println(Benz2.toString());
		
		assertEquals(true, Benz.getCarName().equals(Benz2.getCarName()));
		assertEquals(true, Benz.getSeatNum() == Benz2.getSeatNum());
		assertEquals(false, Benz.getPassengerNum() == Benz2.getPassengerNum());
		assertEquals(true, Benz.getSpeed() == Benz2.getSpeed());
		assertEquals(true, Benz.getAngle() == Benz2.getAngle());
		for (int num_owner = 0; num_owner < Benz.getOwner().size(); num_owner++) {
			assertEquals(true, Benz.getOwner().get(num_owner).equals( Benz2.getOwner().get(num_owner)));
			
		}
		assertEquals(false,Benz.getIdNum() == Benz2.getIdNum());
	
	}

}
