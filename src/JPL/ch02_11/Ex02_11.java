package ch02_11;

public class Ex02_11 {

	public static void main(String[] args) {
		LinkedList Vehicle_list = new LinkedList();

		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");

		Vehicle_list.value = Benz;
		Vehicle_list = Vehicle_list.Add_list(Corolla);
		Vehicle_list = Vehicle_list.Add_list(Crown);

		System.out.println(Vehicle_list);
	}
}

class LinkedList{
	Vehicle value;
	LinkedList next;

	//リストに新しいノードを追加
	LinkedList Add_list(Vehicle value) {
		LinkedList listp = new LinkedList();
		listp.value = value;
		listp.next = this;

		return listp;
	}

	//リストに登録してあるVehicleを全て表示
	void Print_vehicle() {
		LinkedList ref;
		for (ref = this; ref != null; ref = ref.next) {
			System.out.println(ref.value.CarName + ":" + "speed:"
					+ ref.value.speed + ",angle:" + ref.value.angle + ",owner:"
					+ ref.value.owner + ",ID:" + ref.value.idNum);
		}
	}

	// リストに登録されたVehicleをすべて表示
	public String toString() {

		LinkedList ref;
		String desc = "Venicle_List:\n";

		for (ref = this; ref != null; ref = ref.next) {
			desc += (ref.value.CarName + ":" + "speed:" + ref.value.speed
					+ ",angle:" + ref.value.angle + ",owner:" + ref.value.owner
					+ ",ID:" + ref.value.idNum + "\n");
		}

		return desc;
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

	// 識別番号の最大値を取得
	static long Return_max_id() {
		return nextId;
	}

	// 識別番号、車種、持ち主、速さ、角度を出力
	public String toString() {
		String desc = (idNum + "(" + CarName + ")" + "(" + owner + ")" + speed
				+ "," + angle);
		return desc;
	}
}