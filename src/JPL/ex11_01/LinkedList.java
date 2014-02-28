package ex11_01;

class LinkedList<E>{
	private E value;
	private LinkedList<E> next;

	// デフォルトコンストラクタ
	LinkedList() {
		this.value = null;
		this.next = null;
	}

	// コンストラクタ
	LinkedList(E value) {
		this.value = value;
		this.next = null;
	}

	
	//Vehicleのget用アクセッサ
	E getValue() {
		return this.value;
	}
	
	// Vehicleのset用アクセッサ
	void setValue(E value) {
		this.value = value;
	}

	// LinkedList nextのget用アクセッサ
	LinkedList<E> getNextLink() {
		return this.next;
	}

	// リストの先頭に引数のオブジェクトを追加
	LinkedList<E> addListFront(E value) {

		if (this.value == null) {
			this.value = value;
			this.next = null;
			
			return this;
		}
		
		LinkedList<E> listp = new LinkedList<E>();
		listp.value = value;
		listp.next = this;

		return listp;
	}
	
	LinkedList<E> addListEnd(E value) {

		if (this.value == null) {
			this.value = value;
			this.next = null;
			
			return this;
		}
		
		LinkedList<E> listp = new LinkedList<E>();
		LinkedList<E> ref;
		
		for (ref = this; ref.next != null; ref = ref.next) 
			;
		listp.value = value;
		ref.next = listp;
		return this;
	}

	// リストの要素をすべて表示
	public String toString() {

		LinkedList<E> ref;
		String desc = "VLinkedList:\n";

		for (ref = this; ref != null; ref = ref.next) {
			desc += ref.value.toString() + "\n";
		}

		return desc;
	}

	// リストの要素数を取得
	public int inccounter() {
		LinkedList<E> ref;
		int ip = 0;
		for (ref = this; ref != null; ref = ref.next) {
			ip++;
		}
		return ip;
	}
}