package ch01;
import static java.lang.Math.*;

public class Test_static_method {

	public static void main(String[] args) {

		keep_num walk_one = new keep_num();
		keep_num walk_two = new keep_num();

		keep_num.set_next_serial(2000);

		walk_one.set_my_serial(3000);
		walk_two.set_my_serial(4000);

		System.out.println("static" + keep_num.get_next_serial() + "walk_one"
				+ walk_one.get_my_serial() + "walk_two"
				+ walk_two.get_my_serial());

	}

	double x = exp(2.0);

}

class keep_num {
	public static int next_serial;
	public int my_serial;

	public int get_my_serial() {
		return my_serial;
	}

	public void set_my_serial(int num) {
		my_serial = num;
	}

	public static int get_next_serial() {
		return next_serial;
	}

	public static void set_next_serial(int num) {
		next_serial = num;
	}

}