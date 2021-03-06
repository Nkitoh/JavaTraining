package ch02_09;

public class Ex02_09 {

	public static void main(String[] args) {
		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");

		System.out.println(Vehicle.Return_max_id());

	}
}

class Vehicle{
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
	
	// 識別番号の最大値を取得
	static long Return_max_id() {
		return nextId;
	}
}