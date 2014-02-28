package ch02_07;

public class Ex02_07 {

	public static void main(String[] args) {
		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");

		System.out.println("Benz:" + "speed:" + Benz.speed + ",angle:"
				+ Benz.angle + ",owner:" + Benz.owner + ",ID:" + Benz.idNum);
		System.out.println("Corolla:" + "speed:" + Corolla.speed + ",angle:"
				+ Corolla.angle + ",owner:" + Corolla.owner + ",ID:"
				+ Corolla.idNum);

		System.out.println("Crown:" + "speed:" + Crown.speed + ",angle:"
				+ Crown.angle + ",owner:" + Crown.owner + ",ID:" + Crown.idNum);
	}
}

class Vehicle {
	public int speed;
	public int angle;
	public String owner;

	public static long nextId = 0;
	public long idNum;
	
	String CarName;
	
	// デフォルトコンストラクタ
	Vehicle() {
		idNum = nextId++;
	}

	// Vehicleクラスの変数をコンストラクタで初期化
	Vehicle(String CarName, int speed, int angle, String owner) {
		this();
		this.CarName = CarName;
		this.speed = speed;
		this.angle = angle;
		this.owner = owner;
	}
}
