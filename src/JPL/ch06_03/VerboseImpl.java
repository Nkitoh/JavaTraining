package ch06_03;

public class VerboseImpl implements Verbose {
	private How how;
	
	VerboseImpl(){
		how = How.SILENT;
	}
	
	public void setVerbosity(How how){
		this.how = how;
	}
	
	public How getVerbosity(){
		return this.how;
	}
}
