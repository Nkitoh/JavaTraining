package ch04_01;

interface  EnergySource {
	boolean empty();

}

class GasTank implements EnergySource {
	private char gasMeter;

	GasTank(char gasMeter) {
		this.gasMeter = gasMeter;
	}

	public boolean empty() {
		return (this.gasMeter) == 0 ? true : false;
	}

}

class Battery implements EnergySource {
	private char battery;
	
	Battery(char battery){
		this.battery = battery;
	}

	public boolean empty() {
		return (this.battery == 0) ? true : false;
	}
}