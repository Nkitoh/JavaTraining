package ch03_10;

class LinkedList implements Cloneable{
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

	
	//Vehicleのget用アクセッサ
	Vehicle getVehicle() {
		return this.value;
	}
	
	// Vehicleのset用アクセッサ
	void setVehicle(Vehicle value) {
		this.value = value;
	}

	// LinkedList nextのget用アクセッサ
	LinkedList getNextLink() {
		return this.next;
	}

	// リストの先頭に引数のオブジェクトを追加
	LinkedList addListFront(Vehicle value) {

		LinkedList listp = new LinkedList();
		listp.value = value;
		listp.next = this;

		return listp;
	}
	
	void addListEnd(Vehicle value) {

		LinkedList listp = new LinkedList();
		LinkedList ref;
		
		for (ref = this; ref.next != null; ref = ref.next) 
			;
		listp.value = value;
		ref.next = listp;
	}

	// リストの先頭に引数のオブジェクトの配列を追加
	LinkedList addMultiList(Vehicle... value) {
		LinkedList[] listp = new LinkedList[value.length];
		listp[0] = this.addListFront(value[0]);

		for (int i = 1; i < value.length; i++) {
			listp[i] = listp[i - 1].addListFront(value[i]);
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
	
	//cloneメソッド
	public LinkedList clone(){
			LinkedList retList = new LinkedList(this.value.clone());
			LinkedList ref = this;
			
			for (ref = ref.next ; ref != null; ref = ref.next ) 
				retList.addListEnd(ref.value.clone());
				
			return retList;
	}
}