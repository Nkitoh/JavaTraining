package ch02_08;

public class Ex02_08 {

	public static void main(String[] args) {
		
		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");

		LinkedList Vehicle_list = new LinkedList(Benz);

		Vehicle_list = Vehicle_list.Add_list(Corolla);
		Vehicle_list = Vehicle_list.Add_list(Crown);

		Vehicle_list.Print_vehicle();
	}
}

class LinkedList {
	Vehicle value;
	LinkedList next;

	//デフォルトコンストラクタ
	LinkedList() {
		this.value = null;
		this.next = null;
	}

	//引数のvalueをリストのVehicle2_7 value に代入
	LinkedList(Vehicle value) {
		this.value = value;
		this.next = null;
	}

	// リストに新しいノードを追加
	LinkedList Add_list(Vehicle value) {
		LinkedList listp = new LinkedList();
		listp.value = value;
		listp.next = this;

		return listp;
	}

	// リストに登録してあるVehicleを全て表示
	void Print_vehicle() {
		LinkedList ref;
		for (ref = this; ref != null; ref = ref.next) {
			System.out.println(ref.value.CarName + ":" + "speed:"
					+ ref.value.speed + ",angle:" + ref.value.angle + ",owner:"
					+ ref.value.owner + ",ID:" + ref.value.idNum);
		}
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

