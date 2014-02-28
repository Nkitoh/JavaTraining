package ch02_12;

/*
 * Vehicleクラスには、
 * Ownerのみ可変長引数を追加
 * 
 * LinkedListには、
 * Add_multi_listで、
 * 複数のVehicleオブジェクトをリストに追加できるようにした。
 * 
 */

public class Ex02_12 {

	public static void main(String[] args) {

		LinkedList Vehicle_list = new LinkedList();

		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B", "B2",
				"B3");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");
		Vehicle Taxi = new Vehicle("Taxi", 230, -50, "D", "D1");
		Vehicle Bus = new Vehicle("Bus", 2230, -230, "E", "E1", "E2",
				"E3", "E4");

		Vehicle_list.value = Benz;
		Vehicle_list = Vehicle_list.Add_multi_list(Corolla, Crown, Taxi, Bus);

		System.out.println(Vehicle_list);

	}
}

class Vehicle {
	public int speed;
	public int angle;
	public String[] owner;
	
	public static long nextId = 0;
	public long idNum;

	String CarName;

	// デフォルトコンストラクタ
	Vehicle() {
		idNum = nextId++;
	}

	// Vehicleクラスの全ての変数をコンストラクタで初期化
	Vehicle(String CarName, int speed, int angle, String... owner) {
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
	
	// CarName,speed,angle,owner,idを表示
	public String toString() {
		String desc = this.CarName + ":" + "speed:" + this.speed + ",angle:"
				+ this.angle;
		desc += ",owner:";
		for (int i = 0; i < this.owner.length; i++) {
			desc += this.owner[i] + ",";
		}
		desc += "ID:" + this.idNum;
		return desc;
	}

	// CarName,speed,angle,owner,idを表示
	void Print() {
		System.out.print(this.CarName + ":" + "speed:" + this.speed + ",angle:"
				+ this.angle);
		System.out.print(",owner:");
		for (int i = 0; i < this.owner.length; i++) {
			System.out.print(this.owner[i] + ",");
		}
		System.out.println("ID:" + this.idNum);
	}
}

class LinkedList {
	Vehicle value;
	LinkedList next;


	LinkedList() {
		this.value = null;
		this.next = null;
	}

	LinkedList(Vehicle value) {
		this.value = value;
		this.next = null;
	}

	// リストにvalueを追加
	LinkedList Add_list(Vehicle value) {

		LinkedList listp = new LinkedList();
		listp.value = value;
		listp.next = this;

		return listp;
	}

	// リストにvalueを複数個追加
	LinkedList Add_multi_list(Vehicle... value) {
		LinkedList[] listp = new LinkedList[value.length];
		listp[0] = this.Add_list(value[0]);

		for (int i = 1; i < value.length; i++) {
			listp[i] = listp[i - 1].Add_list(value[i]);
		}

		return listp[value.length - 1];
	}

	// リストに登録してあるVehicleを全て表示
	public String toString() {

		LinkedList ref;
		String desc = "Venicle_List:\n";

		for (ref = this; ref != null; ref = ref.next) {
			desc += ref.value.toString() + "\n";
		}

		return desc;
	}	
}
