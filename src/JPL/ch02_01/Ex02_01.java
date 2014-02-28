package ch02_01;

public class Ex02_01 {

	public static void main(String[] args) {

		Vehicle Benz = new Vehicle();

		Benz.speed = 120;
		Benz.angle = 45;
		Benz.owner = "A";

		System.out.println("speed:" + Benz.speed + "angle:" + Benz.angle
				+ "owner:" + Benz.owner);

	}

}

class Vehicle {
	public int speed;
	public int angle;
	public String owner;

}
