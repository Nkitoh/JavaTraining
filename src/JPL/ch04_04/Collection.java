package ch04_04;

import java.util.Iterator;

/**
 * 参考文献
 * http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
 * @author naoya
 *
 */

public interface Collection<E> extends Iterable<E> {
	boolean add(E e);
	boolean addAll(Collection<? extends E> c);
	void clear();
	boolean contains(Object o);
	boolean containsAll(Collection<?> c);
	boolean equals(Object o);
	int hashCode();
	boolean isEmpty();
	Iterator<E> iterator()  ;
	boolean remove(Object o);
	boolean removeAll(Collection<?> c);
	boolean rretainAll(Collection<?> c);
	int size();
	Object[] toArray();
	<T>T[] toArray(T[] a);
}
