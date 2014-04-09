package ex19_01;

/**
 * データ構造のリストクラス
 *
 * @author Naoya Kitoh
 * @version 1.0 
 */
public class LinkedList {
	private Object value;
	private LinkedList next;

	/**
 	* コンストラクタ
 	*
 	* @param value
 	* データ
 	* @param next
 	* 次のノードのアドレス
 	*/
	LinkedList(Object value) {
		this.value = value;
		this.next = null;
	}

	
	/** リストの先頭に引数のオブジェクトを追加
 	* 
 	*@param value
 	*	先頭に追加する要素
 	*/
	public LinkedList addListFront(Object value) {

		LinkedList listp = new LinkedList(value);
		listp.next = this;

		return listp;
	}
	
	/** リストの最後に引数のオブジェクトを追加
 	* 
 	*@param value
 	*	最後追加する要素
 	*/
	public void addListEnd(Object value) {

		LinkedList listp = new LinkedList(value);
		LinkedList ref;
		
		for (ref = this; ref.next != null; ref = ref.next) 
			;
		ref.next = listp;
	}

	/**
 	* リストの先頭に引数のオブジェクトの配列を追加
 	*@param value
 	*	追加する要素
 	*/
	public LinkedList addMultiList(Object... value) {
		LinkedList[] listp = new LinkedList[value.length];
		listp[0] = this.addListFront(value[0]);

		for (int i = 1; i < value.length; i++) {
			listp[i] = listp[i - 1].addListFront(value[i]);
		}

		return listp[value.length - 1];
	}

	/**
 	* リストの要素をすべて表示
 	*@param value
 	*	追加する要素
 	*/
	public String toString() {

		LinkedList ref;
		String desc = "Venicle_List:\n";

		for (ref = this; ref != null; ref = ref.next) {
			desc += ref.value.toString() + "\n";
		}

		return desc;
	}

	// 
	/**
 	*
 	* リストの要素数を取得
 	*@param value
 	*	追加する要素
 	*/
	public int inccounter() {
		LinkedList ref;
		int ip = 0;
		for (ref = this; ref != null; ref = ref.next) {
			ip++;
		}
		return ip;
	}
	
}
