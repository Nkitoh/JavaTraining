package ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class FindFile implements FilenameFilter{
	private File dir;
	private String suffix;
	
	public FindFile(File dir, String suffix) {
		this.dir = dir;
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(suffix);
	}
	
	public String[] getList() {
		return dir.list(this);
	}
	
	public void print() {
		for (String s: this.getList())
			System.out.println(s);
	}
	
	public static void main(String[] args) {
		File f = new File("src/ex20_10");
		FindFile ff = new FindFile(f, ".java");
		
		ff.print();
	}

}
