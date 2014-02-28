package ch01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/*
public class Test_output {
	public static void main(String[] argv) throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(
				new FileOutputStream("test.txt"));
		writer.write("あいう");
		writer.close();
	}
}
*/

public class Test_output {
	   public static void main(String args[]){
	     try{
	      String s;
	      FileInputStream in=new FileInputStream("test.txt");
	      s=readString(in);
	      while(s!=null){
	        System.out.println(s);
	        s=readString(in);
	      }
	       in.close();
	    }catch(IOException e){
	      System.out.println("Err="+e);
	     }
	   }

	   static String readString(InputStream in){
	     try{
	       int l;
	      int a;
	      byte b[]=new byte[2048];
	      a=in.read();
	      if (a<0) return null;
	      l=0;
	       while(a>10){
	        if (a>=' '){
	          b[l]=(byte)a;
	           l++;
	         }
	         a=in.read();
	      }
	       return new String(b,0,l);
	    }catch(IOException e){
	       
	      System.out.println("Err="+e);
	       return null;
	     }
	   }
	 }

