package ch02_02;

public class Ex02_02 {

	public static void main(String[] args) {

		LinkedList test_list = new LinkedList();

		test_list.value = 1;
		test_list = test_list.Add_list(2);
		test_list = test_list.Add_list(3);
		test_list.Print_list();
	}

}

class LinkedList {
	Object value;
	LinkedList next;

	//リストに新しいノードを追加
	LinkedList Add_list(Object value) {
		LinkedList listp = new LinkedList();
		listp.value = value;
		listp.next = this;
		return listp;
	}

	//リストに登録してあるvalueを全て表示
	void Print_list() {
		for (LinkedList ref = this; ref != null; ref = ref.next) {
			System.out.println("value:" + ref.value);
		}
	}
}
