package ch06_03;

interface Verbose {
	enum How{
		SILENT,
		TERSE,
		NORMAL,
		VERBOSE,
	}
	
	void setVerbosity(How how);
	How getVerbosity();
}
