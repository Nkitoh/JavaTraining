package ex12_01;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testFind() throws NoValueListException {
		int N = 10;
		LinkedList<String> list = new LinkedList<String>();
		String[] ans = new String[N];

		// test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new String();
			ans[i] = String.format("test%d", i);
			list = list.addListFront(ans[i]);
		}

		LinkedList<String> ref;
		for (int i = 0; i < ans.length; i++) {
			ref = list.find(ans[i]);
			assertTrue(ref.getValue().equals(ans[i]));
		}
	}

	@Test(expected = NoValueListException.class)
	public void testFindFail() throws NoValueListException {
		int N = 10;
		LinkedList<String> list = new LinkedList<String>();
		String[] ans = new String[N];

		// test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new String();
			ans[i] = String.format("test%d", i);
			list = list.addListFront(ans[i]);
		}

		list.find("not_found");

	}

}
