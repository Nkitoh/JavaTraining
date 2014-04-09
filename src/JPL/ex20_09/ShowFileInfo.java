package ex20_09;

import java.io.File;

public class ShowFileInfo {
	private File file;
	
	public ShowFileInfo (File file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		StringBuilder retStr = new StringBuilder();
		
		retStr.append("AbsoluteFile:" + file.getAbsoluteFile() + '\n');
		retStr.append("AbsolutePath:" + file.getAbsolutePath()+ '\n');
		retStr.append("FreeSpace:" + file.getFreeSpace()+ '\n');
		retStr.append("Name:" + file.getName()+ '\n');
		retStr.append("Parent:" + file.getParent()+ '\n');
		retStr.append("ParentFile:" + file.getParentFile()+ '\n');
		retStr.append("Path:" + file.getPath()+ '\n');
		retStr.append("TotalSpace:" + file.getTotalSpace()+ '\n');
		retStr.append("UsableSpace:" + file.getUsableSpace()+ '\n');
		
		return retStr.toString();
	}
	/*
	AbsoluteFile:C:\myspace\section01\src\ex20_09\ShowFileInfo.java
	AbsolutePath:C:\myspace\section01\src\ex20_09\ShowFileInfo.java
	FreeSpace:627603734528
	Name:ShowFileInfo.java
	Parent:src\ex20_09
	ParentFile:src\ex20_09
	Path:src\ex20_09\ShowFileInfo.java
	TotalSpace:729074749440
	UsableSpace:627603734528
	*/
	public static void main(String[] args) {
		File f = new File("src/ex20_09/ShowFileInfo.java");
		ShowFileInfo showFile = new ShowFileInfo(f);
		System.out.println(showFile.toString());
	}
}
