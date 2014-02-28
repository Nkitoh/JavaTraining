package ex09_01;

public class Infinity {

	public static void main(String[] args) {
		calcInfinity(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		calcInfinity(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
		calcInfinity(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);

	}

	static void calcInfinity(Double x, Double y) {
		System.out.printf("x:%f y:%f\n", x, y);
		System.out.println("***********************");
		System.out.printf("x + y: %f\n", x + y);
		System.out.printf("x - y: %f\n", x - y);
		System.out.printf("x * y: %f\n", x * y);
		System.out.printf("x / y: %f\n", x / y);
	}

}
