package ch03_06;

abstract class  EnergySource {
	abstract boolean empty();

}

class GasTank extends EnergySource {
	private char gasMeter;

	GasTank(char gasMeter) {
		this.gasMeter = gasMeter;
	}

	public boolean empty() {
		return (this.gasMeter) == 0 ? true : false;
	}

}

class Battery extends EnergySource {
	private char battery;
	
	Battery(char battery){
		this.battery = battery;
	}

	public boolean empty() {
		return (this.battery == 0) ? true : false;
	}
}