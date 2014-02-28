package ch03_04;
/**
 * アクセッサメソッドはfinalにしたほうがよいと考える
 * @author naoya
 *
 */

public class Ex03_04 {

	public static void main(String[] args) {

		PassengerVehicle Benz = new PassengerVehicle("Benz", 4, 2, 120, 45,
				"A1", "A2", "A3");
		PassengerVehicle Corolla = new PassengerVehicle("Corolla", 4, 1, 40,
				70, "B", "B2", "B3");
		PassengerVehicle Crown = new PassengerVehicle("Crown", 4, 4, 20, 150,
				"C");
		PassengerVehicle Taxi = new PassengerVehicle("Taxi", 4, 2, 230, -50,
				"D", "D1");
		PassengerVehicle Bus = new PassengerVehicle("Bus", 20, 12, 2230, -230,
				"E", "E1", "E2", "E3", "E4");

		System.out.println(Benz);
		System.out.println(Corolla);
		System.out.println(Crown);
		System.out.println(Taxi);
		System.out.println(Bus);

	}
}
