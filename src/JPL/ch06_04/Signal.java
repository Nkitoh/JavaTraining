package ch06_04;

public enum Signal {
	RED, YELLOW, GREEN;

	static Color Red = new Color("RED");
	static Color Yellow = new Color("YELLOW");
	static Color Green = new Color("GREEN");
	
	static Color getColor(Signal color){
		switch(color){
		case RED:
			return Red;
		case YELLOW:
			return Yellow;
		case GREEN:
			return Green;
		default:
			throw new AssertionError("Unknown" + color);
		}
	}
}
