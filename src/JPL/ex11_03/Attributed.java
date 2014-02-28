package ex11_03;

//ジェネリクス型にすることで、AttrのvalueをObject型ではなく、Eにすることができる。
//よって型が安全になるので、ジェネリクスにするほうがよいと考える。
//Attributedもジェネリクスを使った、インターフェイスにすることで、型が安全になると考える。

public interface Attributed<E> {
	void add(Attr<E> newAttr);
	Attr<E> find(String attrName);
	Attr<E> remove(String attrName);
	java.util.Iterator<Attr<E>> attrs();
}
