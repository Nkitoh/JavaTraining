package ch02_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Ex02_16 {

	public static void main(String[] args) {
		LinkedList Vehicle_list = new LinkedList();

		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B", "B2",
				"B3");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");
		Vehicle Taxi = new Vehicle("Taxi", 230, -50, "D", "D1");
		Vehicle Bus = new Vehicle("Bus", 2230, -230, "E", "E1", "E2",
				"E3", "E4");

		Vehicle_list.set_object(Benz);
		Vehicle_list = Vehicle_list.Add_multi_list(Corolla, Crown, Taxi, Bus);

		// System.out.println("Hello");
		System.out.println(Vehicle_list.inccounter());
	}
}

class LinkedList {
	private Vehicle value;
	private LinkedList next;

	// デフォルトコンストラクタ
	LinkedList() {
		this.value = null;
		this.next = null;
	}

	// コンストラクタ
	LinkedList(Vehicle value) {
		this.value = value;
		this.next = null;
	}

	// Vehicle2_13のset用アクセッサ
	void set_object(Vehicle value) {
		this.value = value;
	}

	// LinkedList2_14 nextのget用アクセッサ
	LinkedList get_next_link() {
		return this.next;
	}

	// リストの先頭に引数のオブジェクトを追加
	LinkedList Add_list(Vehicle value) {

		LinkedList listp = new LinkedList();
		listp.value = value;
		listp.next = this;

		return listp;
	}

	// リストの先頭に引数のオブジェクトの配列を追加
	LinkedList Add_multi_list(Vehicle... value) {
		LinkedList[] listp = new LinkedList[value.length];
		listp[0] = this.Add_list(value[0]);

		for (int i = 1; i < value.length; i++) {
			listp[i] = listp[i - 1].Add_list(value[i]);
		}

		return listp[value.length - 1];
	}

	// リストの要素をすべて表示
	public String toString() {

		LinkedList ref;
		String desc = "Venicle_List:\n";

		for (ref = this; ref != null; ref = ref.next) {
			desc += ref.value.toString() + "\n";
		}

		return desc;
	}

	// リストの要素数を取得
	public int inccounter() {
		LinkedList ref;
		int ip = 0;
		for (ref = this; ref != null; ref = ref.next) {
			ip++;
		}
		return ip;
	}
}

class Vehicle {

	private int speed;
	private int angle;
	private List<String> owner;

	private static long nextId = 0;
	private long idNum;

	private String CarName;

	// デフォルトコンストラクタ
	Vehicle() {
		idNum = nextId++;
	}

	// Vehicleクラスの全ての変数をコンストラクタで初期化
	Vehicle(String CarName, int speed, int angle, String... owner) {
		idNum = nextId;
		nextId++;
		this.CarName = CarName;
		this.speed = speed;
		this.angle = angle;
		this.owner = new ArrayList<String>(Arrays.asList(owner));
	}

	// CarName,speed,angle,owner,idを表示
	public String toString() {
		String desc = this.CarName + ":" + "speed:" + this.speed + ",angle:"
				+ this.angle;
		desc += ",owner:";
		for (int i = 0; i < this.owner.size(); i++) {
			desc += this.owner.get(i) + ",";
		}
		desc += "ID:" + this.idNum;
		return desc;
	}

	// 指定されたVehicleクラスの情報を表示
	static public void Print(Vehicle... vehicle) {
		for (int i = 0; i < vehicle.length; i++) {
			System.out.print(vehicle[i].CarName + ":" + "speed:"
					+ vehicle[i].speed + ",angle:" + vehicle[i].angle);

			System.out.print(",owner:");
			for (int num_owner = 0; num_owner < vehicle[i].owner.size(); num_owner++) {
				System.out.print(vehicle[i].owner.get(num_owner) + ",");
			}

			System.out.println("ID:" + vehicle[i].idNum);
		}
	}

	// 識別番号取得
	long get_idNum() {
		return this.idNum;
	}

	// 速さを取得
	int get_speed() {
		return this.speed;
	}

	// 速さを設定
	void set_speed(int speed) {
		this.speed = speed;
	}

	// 角度を取得
	int get_angle() {
		return this.angle;
	}

	// 車種を取得
	String get_CarName() {
		return this.CarName;
	}

	// 角度を設定
	void set_angle(int angle) {
		this.angle = angle;
	}

	// 持ち主を取得
	List<String> get_owner() {
		return this.owner;
	}

	// 持ち主を追加
	void set_owner(String owner) {
		this.owner.add(owner);
	}

	// 持ち主を削除
	void delete_owner(String owner) {
		this.owner.remove(owner);
	}

	// 速さを設定
	void changeSpeed(int speed) {
		this.set_speed(speed);
	}

}