package ch02_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * idNumはset用のアクセッサは必要ない
 * nextIdはget用、set用両方のアクセッサが必要ない
 * 
 * speed、angleはget、setともにアクセッサが必要である。
 * 
 * ownerはset、get、delete、addが必要と考える。
 *
 *CarNameは変更する必要はないので、getのみとする。
 */
public class Ex02_13 {

	public static void main(String[] args) {
		Vehicle Benz = new Vehicle("Benz", 120, 45, "A");
		Vehicle Corolla = new Vehicle("Corolla", 240, 70, "B", "B2", "B3");
		Vehicle Crown = new Vehicle("Crown", 20, 150, "C");
		Vehicle Taxi = new Vehicle("Taxi", 230, -50, "D", "D1");
		Vehicle Bus = new Vehicle("Bus", 2230, -230, "E", "E1", "E2", "E3",
				"E4");

		Vehicle.Print(Benz, Corolla, Crown, Taxi, Bus);

		// getメソッドのテスト
		System.out.println("test_get speed:" + Corolla.get_speed() + "angle:"
				+ Corolla.get_angle());

		Benz.set_owner("A2");
		Bus.delete_owner("E2");
		Bus.delete_owner("FFF");

		Vehicle.Print(Benz, Corolla, Crown, Taxi, Bus);
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
}