package ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream{
	int enc = 101;
	
	public EncryptOutputStream(OutputStream out) {
		super(out);
	}
	
	@Override
	public void write(int c) throws IOException {
		//c ^= enc;
		super.write(c^enc);
	}
}
