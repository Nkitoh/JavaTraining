package ch02_04;

/**
 * 識別番号は、頻繁に変更されないだけであり、 オブジェクトが生成された時点で値が決まっているわけではないので、 識別番号はfinalとすべきではない。
 * 識別番号であるidNumをpubilic final long idNum とするとコンパイルエラーとなった。 (ブランクの final フィールド
 * idNum は初期化されていない可能性があります)
 */
public class Ex02_04 {

	public static void main(String[] args) {
		Vehicle Benz = new Vehicle();
		Vehicle Corolla = new Vehicle();

		Benz.speed = 120;
		Benz.angle = 45;
		Benz.owner = "A";
		Benz.idNum = Vehicle.nextId;
		Vehicle.nextId++;

		Corolla.speed = 240;
		Corolla.angle = 75;
		Corolla.owner = "B";
		Corolla.idNum = Vehicle.nextId;
		Vehicle.nextId++;

		System.out.println("Benz:" + "speed:" + Benz.speed + ",angle:"
				+ Benz.angle + ",owner:" + Benz.owner + ",ID:" + Benz.idNum);
		System.out.println("Corolla:" + "speed:" + Corolla.speed + ",angle:"
				+ Corolla.angle + ",owner:" + Corolla.owner + ",ID:"
				+ Corolla.idNum);
	}
}

class Vehicle {
	public int speed;
	public int angle;
	public String owner;
	
	public static long nextId = 0;
	public long idNum;

	//public final long idNum = nextId;

}
