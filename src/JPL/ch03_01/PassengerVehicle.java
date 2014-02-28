package ch03_01;

class PassengerVehicle extends Vehicle{
	private final int seatNum;
	private int passengerNum;
	

	// PassengerVehicleクラスの全ての変数をコンストラクタで初期化
	PassengerVehicle(String CarName,int seatNum, int passengerNum, int speed, int angle, String... owner) {
		super(CarName, speed, angle,owner);
		
		this.seatNum = seatNum;
		this.passengerNum = passengerNum;
	}
	
	//シートの数を取得
	int getSeatNum(){
		return this.seatNum;
	}
	
	//乗客人数の取得
	int getPassengerNum(){
		return this.passengerNum;
	}
	
	//乗客人数の設定
	void setPassengerNum(int passengerNum){
		this.passengerNum = passengerNum;
	}
	
	//PassengerVehicleのtoStringメソッド
	public String toString() {
		String desc =  getCarName() + ":" + "seatNum:" + this.seatNum + ",passengerNum:" + this.passengerNum + ",speed:" + getSpeed() + ",angle:"
				+ getAngle();
		desc += ",owner:";
		for (int i = 0; i < getOwner().size(); i++) {
			desc += getOwner().get(i) + ",";
		}
		desc += "ID:" + getIdNum();
		return desc;
	}
	
}
