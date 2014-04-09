package ex20_02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


//abc→
//b
//b
//c
public class TranslateByte extends FilterReader{
	private byte from;
	private byte to;
	
	public TranslateByte(Reader in, byte from, byte to) {
		super(in);
		
		this.from = from;
		this.to   = to;
	}
	
	@Override
	public int read() throws IOException {
		int c = super.read();
		
		return(c == from ? to:c);
	}
	
	public static void main(String[] args) throws IOException {
		Reader in = new InputStreamReader(System.in);
		TranslateByte tb = new TranslateByte(in, (byte)'a',(byte)'b');
        
		int c;
		while ((c = tb.read()) != -1)
			System.out.println((char)c);
		System.out.println();
	}
}
