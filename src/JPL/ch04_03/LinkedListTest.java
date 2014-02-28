package ch04_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testTure() {
		LinkedList vehicleList = new LinkedListImpl();
		LinkedList cloneList;

		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B", "B2",
				"B3");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");
		Vehicle Taxi = new Vehicle("Taxi", 230, -50, "D", "D1");
		Vehicle Bus = new Vehicle("Bus", 2230, -230, "E", "E1", "E2",
				"E3", "E4");

		vehicleList.setVehicle(Benz);
		vehicleList = vehicleList.addMultiList(Corolla, Crown, Taxi, Bus);
		
		cloneList = vehicleList.clone();
		assertEquals(true,vehicleList.toString().equals(cloneList.toString()));
	
	
	}
	
	@Test
	public void testFalse() {
		LinkedList vehicleList = new LinkedListImpl();
		LinkedList cloneList;

		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B", "B2",
				"B3");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");
		Vehicle Taxi = new Vehicle("Taxi", 230, -50, "D", "D1");
		Vehicle Bus = new Vehicle("Bus", 2230, -230, "E", "E1", "E2",
				"E3", "E4");

		vehicleList.setVehicle(Benz);
		vehicleList = vehicleList.addMultiList(Corolla, Crown, Taxi, Bus);
		
		cloneList = vehicleList.clone();
		
		vehicleList.addListEnd(Benz);

		assertEquals(false,vehicleList.toString().equals(cloneList.toString()));
	}
}
