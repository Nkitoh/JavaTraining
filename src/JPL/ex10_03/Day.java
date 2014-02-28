package ex10_03;

public class Day {

	static boolean workUsingIf(Week day) {
		if (day == Week.SATURDAY || day == Week.SUNDAY)
			return false;
		else
			return true;
	}

	static boolean workUsingSwitch(Week day) {
		switch (day) {
		case SATURDAY:
		case SUNDAY:
			return false;
		default:
			return true;
		}
	}
}
