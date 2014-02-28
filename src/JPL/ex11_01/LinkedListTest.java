package ex11_01;

import static org.junit.Assert.*;

import org.junit.Test;

//アクセッサメソッド
//addListForntメソッド
//addListEndメソッド
//inccounterメソッド

public class LinkedListTest {
	public final int N = 6;
	
	@Test
	public void testStringAddListFront() {
		LinkedList<String> list = new LinkedList<String>();
		String[] ans = new String[N];
		
		//test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new String();
			ans[i] = String.format("test%d", i);
			list = list.addListFront(ans[i]);
			
		}
		
		int i = ans.length - 1;
		for (LinkedList<String> ref = list; ref != null; ref = ref.getNextLink()) {
			assertTrue(ref.getValue().equals(ans[i]));
			i--;
		}
	}
	
	@Test
	public void testStringAddListEnd() {
		LinkedList<String> list = new LinkedList<String>();
		String[] ans = new String[N];
		
		//test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new String();
			ans[i] = String.format("test%d", i);
			list = list.addListEnd(ans[i]);
			
		}
	
		int i = 0;
		for (LinkedList<String> ref = list; ref != null; ref = ref.getNextLink()) {
			
			assertTrue(ref.getValue().equals(ans[i]));
			
			i++;
		}
	}
	
	@Test
	public void testStringIncclunter() {
		LinkedList<String> list = new LinkedList<String>();
		String[] ans = new String[N];
		
		//test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new String();
			ans[i] = String.format("test%d", i);
			list = list.addListEnd(ans[i]);
			
		}
		assertTrue(list.inccounter() == ans.length);
	}
	
	@Test
	public void testIntegerAddListFront() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Integer[] ans = new Integer[N];
		
		//test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new Integer(i);
			list = list.addListFront(ans[i]);
		}
		
		int i = ans.length - 1;
		for (LinkedList<Integer> ref = list; ref != null; ref = ref.getNextLink()) {
			assertTrue(ref.getValue() == ans[i]);
			i--;
		}
	}
	
	@Test
	public void testIntegerddListEnd() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Integer[] ans = new Integer[N];
		
		//test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new Integer(i);
			list = list.addListEnd(ans[i]);
		}
	
		int i = 0;
		for (LinkedList<Integer> ref = list; ref != null; ref = ref.getNextLink()) {
			
			assertTrue(ref.getValue().equals(ans[i]));
			
			i++;
		}
	}
	
	@Test
	public void testIntegerIncclunter() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Integer[] ans = new Integer[N];
		
		//test0 ~ testNまでを代入
		for (int i = 0; i < ans.length; i++) {
			ans[i] = new Integer(i);
			list = list.addListEnd(ans[i]);
			
		}
		assertTrue(list.inccounter() == ans.length);
	}

}
