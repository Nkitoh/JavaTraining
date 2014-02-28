package ch04_03;

public class LinkedListImpl implements LinkedList, Cloneable{
	private Vehicle value;
	private LinkedListImpl next;

	// デフォルトコンストラクタ
	LinkedListImpl() {
		this.value = null;
		this.next = null;
	}

	// コンストラクタ
	LinkedListImpl(Vehicle value) {
		this.value = value;
		this.next = null;
	}

	// Vehicleのget用アクセッサ
	public Vehicle getVehicle() {
		return this.value;
	}

	// Vehicleのset用アクセッサ
	public void setVehicle(Vehicle value) {
		this.value = value;
	}

	// LinkedList nextのget用アクセッサ
	public LinkedListImpl getNextLink() {
		return this.next;
	}

	// リストの先頭に引数のオブジェクトを追加
	public LinkedListImpl addListFront(Vehicle value) {

		LinkedListImpl listp = new LinkedListImpl();
		listp.value = value;
		listp.next = this;

		return listp;
	}

	public void addListEnd(Vehicle value) {

		LinkedListImpl listp = new LinkedListImpl();
		LinkedListImpl ref;

		for (ref = this; ref.next != null; ref = ref.next)
			;
		listp.value = value;
		ref.next = listp;
	}

	// リストの先頭に引数のオブジェクトの配列を追加
	public LinkedListImpl addMultiList(Vehicle... value) {
		LinkedListImpl[] listp = new LinkedListImpl[value.length];
		listp[0] = this.addListFront(value[0]);

		for (int i = 1; i < value.length; i++) {
			listp[i] = listp[i - 1].addListFront(value[i]);
		}

		return listp[value.length - 1];
	}

	// リストの要素をすべて表示
	public String toString() {

		LinkedListImpl ref;
		String desc = "Venicle_List:\n";

		for (ref = this; ref != null; ref = ref.next) {
			desc += ref.value.toString() + "\n";
		}

		return desc;
	}

	// リストの要素数を取得
	public int inccounter() {
		LinkedListImpl ref;
		int ip = 0;
		for (ref = this; ref != null; ref = ref.next) {
			ip++;
		}
		return ip;
	}

	// cloneメソッド
	public LinkedListImpl clone() {
		LinkedListImpl retList = new LinkedListImpl(this.value.clone());
		LinkedListImpl ref = this;

		for (ref = ref.next; ref != null; ref = ref.next)
			retList.addListEnd(ref.value.clone());

		return retList;
	}
}
