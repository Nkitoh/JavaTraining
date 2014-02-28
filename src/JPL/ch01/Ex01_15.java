package ch01;

import java.util.ArrayList;
import java.util.List;

public class Ex01_15 {

	public static void main(String[] args) {
		ImprovedLookdupImpl Table = new ImprovedLookdupImpl();

		System.out.println("Test add");
		Table.add("A", 1);
		Table.add("B", 2);
		Table.add("B", 2);
		Table.add("C", 3);
		Table.add("D", 4);
		Table.add("E", 5);
		
		Table.print();
		
		System.out.println("Test remove");
		Table.remove("A");
		Table.print();

		System.out.println("Test find");
		System.out.println(Table.find("B"));
	}

}

// findを定義したインターフェイス
interface Lookup {
	Object find(String name);
}

// addとremoveを追加したインターフェイス
interface ImprovedLookup extends Lookup {
	void add(String name, Object value);

	void remove(String name);
}

// find、add、removeを実装したクラス
class ImprovedLookdupImpl implements ImprovedLookup {
	private List<String> names = new ArrayList<String>();
	private List<Object> values = new ArrayList<Object>();

	public Object find(String name) {
		if (this.names.contains(name)) {
			int index = this.names.indexOf(name);
			return this.values.get(index);
		}
		return null;
	}

	public void add(String name, Object value) {
		this.names.add(name);
		this.values.add(value);
	}

	public void remove(String name) {
		if (this.names.contains(name)) {
			int index = this.names.indexOf(name);
			this.names.remove(index);
			this.values.remove(index);
		}
	}

	public void print() {
		for (int i = 0; i < this.names.size(); i++) {
			System.out.println("Name:" + this.names.get(i) + ",Value:"
					+ this.values.get(i));
		}
	}
}