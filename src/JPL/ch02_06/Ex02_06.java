package ch02_06;

public class Ex02_06 {
	static final int NUM = 3;

	public static void main(String[] args) {
		LinkedList Vehicle_list = new LinkedList();

		Vehicle Benz = new Vehicle();
		Vehicle Corolla = new Vehicle();
		Vehicle Crown = new Vehicle();

		Benz.CarName = "Benz";
		Benz.speed = 120;
		Benz.angle = 45;
		Benz.owner = "A";
		Benz.idNum = Vehicle.nextId;
		Vehicle.nextId++;

		Corolla.CarName = "Corolla";
		Corolla.speed = 240;
		Corolla.angle = 70;
		Corolla.owner = "B";
		Corolla.idNum = Vehicle.nextId;
		Vehicle.nextId++;

		Crown.CarName = "Crown";
		Crown.speed = 20;
		Crown.angle = 150;
		Crown.owner = "C";
		Crown.idNum = Vehicle.nextId;
		Vehicle.nextId++;

		Vehicle_list.value = Benz;
		Vehicle_list = Vehicle_list.Add_list(Corolla);
		Vehicle_list = Vehicle_list.Add_list(Crown);

		Vehicle_list.Print_vehicle();
	}
}

class LinkedList {
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
}

class Vehicle{
	public int speed;
	public int angle;
	public String owner;

	public static long nextId = 0;
	public long idNum;
	
	String CarName;
}
