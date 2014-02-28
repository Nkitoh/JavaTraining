package ch05_01;


public class Ex05_01_nest {

	public static void main(String[] args) {
		AttributedImpl attrMap = new AttributedImpl();
		attrMap.add(new AttributedImpl.Attr("apple", "red"));
		attrMap.add(new AttributedImpl.Attr("lemon", "yellow"));
		attrMap.add(new AttributedImpl.Attr("carrot", "orange"));
		System.out.println(attrMap.find("apple"));
		System.out.println(attrMap.find("lemon"));
		System.out.println(attrMap.find("carrot"));
	}

}
