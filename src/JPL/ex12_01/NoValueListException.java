package ex12_01;

public class NoValueListException extends Exception{
	public final Object value;
	
	public NoValueListException(Object not_found) {
		super("No Value" + (String)not_found );
		value = not_found;
	}
}
