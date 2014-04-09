package ex17_01;
//Init:126345528
//MakeObject:124521864
//FreeObject:126178368

public class ShowFreeMemory {
	public static void main(String[] args) {
		System.out.println("Init:" + Runtime.getRuntime().freeMemory());

		for (int i = 0; i < 1000000; i++) {
			Integer array = new Integer(i);
		}

		System.out.println("MakeObject:" + Runtime.getRuntime().freeMemory());

		System.gc();

		System.out.println("FreeObject:" + Runtime.getRuntime().freeMemory());
	}

}
