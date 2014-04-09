package ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Attr {
	private final String name;
	private Object value = null;
	
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public Attr (DataInputStream in) throws IOException {
		this.name = in.readUTF();
		this.value = in.readUTF();
	}
	
	public void writeData (DataOutputStream out) throws IOException {
		out.writeUTF(this.name);
		out.writeUTF(this.value.toString());
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString() {
		return name + "='" + value + "'";
	}
}
