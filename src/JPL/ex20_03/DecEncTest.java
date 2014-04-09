package ex20_03;

import java.io.IOException;

public class DecEncTest {

	public static void main(String[] args) throws IOException{
		DecryptInputStream dec = new DecryptInputStream(System.in);
        
		int c;

		EncryptOutputStream enc = new EncryptOutputStream(System.out);
		//abc
		//System.out.print
		//476104111
		//
		//enc.write
		//abc
		while ((c = dec.read()) != -1)
			enc.write(c);
		//System.out.print(c);
		
	}

}
