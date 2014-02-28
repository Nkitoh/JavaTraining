package ch01;

import java.awt.Color;

public class Test_object {

	public static void main(String[] args) {
		Object oref = new Pixel();
		
		oref = "Some String";

		//oref.clear();
		System.out.println(oref);
		//System.out.println(oref.x);
	}

}

class Pixel extends Point_test{
	Color color;
	
	public void clear(){
		super.clear();
		color = null;
	}
	
}
