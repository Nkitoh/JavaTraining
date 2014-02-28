package ch04_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Vehicle{
	private int speed;
	private int angle;
	private List<String> owner;

	private static long nextId = 0;
	private long idNum;

	private String CarName;
	
	private EnergySource Energy;

	// デフォルトコンストラクタ
	Vehicle() {
		idNum = nextId++;
	}

	// Vehicleクラスの全ての変数をコンストラクタで初期化
	Vehicle(EnergySource Energy,String CarName, int speed, int angle, String... owner) {
		idNum = nextId;
		nextId++;
		this.Energy = Energy;
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
	long getIdNum() {
		return this.idNum;
	}

	// 速さを取得
	int getSpeed() {
		return this.speed;
	}

	// 速さを設定
	void setSpeed(int speed) {
		this.speed = speed;
	}

	// 角度を取得
	int getAngle() {
		return this.angle;
	}

	// 車種を取得
	String getCarName() {
		return this.CarName;
	}

	// 角度を設定
	void setAngle(int angle) {
		this.angle = angle;
	}

	// 持ち主を取得
	List<String> getOwner() {
		return this.owner;
	}

	// 持ち主を追加
	void setOwner(String owner) {
		this.owner.add(owner);
	}

	// 持ち主を削除
	void deleteOwner(String owner) {
		this.owner.remove(owner);
	}

	// 速さを設定
	void changeSpeed(int speed) {
		this.setSpeed(speed);
	}
	// angleの値を変更
	void changeAngle(int angle) {
		setAngle(angle);
	}

	// 左に９０度曲がる
	int TURN_LEFT() {
		return getAngle() + 90;
	}

	// 右に９０度曲がる
	int TURN_RIGHT() {
		return getAngle() - 90;
	}
	
	//エネルギーの量を判定
	 String start(){
		 String validateEnergy ;
		if(!Energy.empty()){
			validateEnergy = "Start!";
		} else{
			validateEnergy ="No Enegy!";
		}
		
		return validateEnergy ;
	}
}