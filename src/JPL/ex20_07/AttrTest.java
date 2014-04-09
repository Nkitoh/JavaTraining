package ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AttrTest {

	public static void main(String[] args) throws IOException{
		Object obj = new Object();
		Attr test1_out = new Attr("test1", "testObject");
		Attr test2_out = new Attr("test2", 12);
		Attr test3_out = new Attr("test3",obj);
		
		FileOutputStream out = new FileOutputStream("src/ex20_07/out.txt");
		DataOutputStream outData = new DataOutputStream(out);
		
		test1_out.writeData(outData);
		test2_out.writeData(outData);
		test3_out.writeData(outData);
		
		FileInputStream in = new FileInputStream("src/ex20_07/out.txt");
		DataInputStream inData = new DataInputStream(in);
		
		Attr test1_in= new Attr(inData);
		Attr test2_in = new Attr(inData);
		Attr test3_in = new Attr(inData);
		
		System.out.println(test1_in.toString());
		System.out.println(test2_in.toString());
		System.out.println(test3_in.toString());
	}
	
}
