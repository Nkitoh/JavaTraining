package ch02_03;

public class Ex02_03 {

	public static void main(String[] args) {
		Vehicle Benz  = new Vehicle();
		Vehicle Corolla  = new Vehicle();
		
		Benz.speed = 120;
		Benz.angle = 45;
		Benz.owner = "A";
		Benz.idNum =Vehicle.nextId;
		Vehicle.nextId++;
		
		Corolla.speed = 240;
		Corolla.angle = 70;
		Corolla.owner = "B";
		Corolla.idNum =Vehicle.nextId;
		Vehicle.nextId++;
		
		System.out.println("Benz:" + "speed:" +Benz.speed + ",angle:" + Benz.angle + 
				",owner:" + Benz.owner  + ",ID:" + Benz.idNum);
		System.out.println("Corolla:" + "speed:" + Corolla.speed + ",angle:" + Corolla.angle + 
				",owner:" + Corolla.owner  + ",ID:" + Corolla.idNum);

	}

}

class Vehicle
{
	public int speed;
	public int angle;
	public String owner;
	
	public static long nextId = 0;
	public long idNum;
	
}
