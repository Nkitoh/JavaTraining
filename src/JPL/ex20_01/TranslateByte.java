package ex20_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {
	static void ItoO(InputStream input, OutputStream output, byte from, byte to)
			throws IOException {

		int b;
		while ((b = input.read()) != -1) {
			output.write(b == from ? to : b);
			throw new IOException();
		}

	}

	public static void main(String[] args) {
		try {
		 ItoO(System.in, System.out, (byte)args[0].charAt(0),(byte)args[1].charAt(0));
		 } catch (IOException e){
			 e.getMessage();
		 }
	}
}
