package ch03_03;

public class Ex03_03 {

	public static void main(String[] args) {
		Y testY = new Y();
	}

}

class X {
	protected int xMask = 0x00ff;
	static protected int fullMask;
	
	
	public X() {
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,0,fullMask);
		fullMask = xMask;
		fullMask = mask(0x00ff);
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,0,fullMask);
		
	}
	
	private int mask(int orig) {
		System.out.println("Xmask");
		return (orig & fullMask);
	}
}

class Y extends X {
	protected int yMask = 0xff00;
	
	public Y() {
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,yMask,fullMask);
		//fullMask |= yMask;
		fullMask = mask(0x00ff);
		System.out.printf("xMask: %0#6x yMask: %0#6x fullMask: %0#6x %n",xMask,yMask,fullMask);
	}
	
	private int mask(int orig) {
		System.out.println("Ymask");
		return (orig & fullMask);
	}
	
}
