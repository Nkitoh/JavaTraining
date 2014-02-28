package ch03_02;

public class Ex03_02 {

	public static void main(String[] args) {
		Y testY = new Y();
	}

}

class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	
	public X() {
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,0,fullMask);
		fullMask = xMask;
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,0,fullMask);
		
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}
}

class Y extends X {
	protected int yMask = 0xff00;
	
	public Y() {
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,yMask,fullMask);
		fullMask |= yMask;
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,yMask,fullMask);
	}
	
	
}
