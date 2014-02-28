package ex10_01;

public class EsToStringFor {
	
	static String esToString(String str) {
		StringBuffer changeStr = new StringBuffer(str.length());
		
		for(int i = 0; i < str.length(); i++)
			changeStr.append(changeEs(str.charAt(i)));
		return changeStr.toString();
	}

	static String changeEs(char c) {
		if (c == '\n') {
            return "\\n";
        }
        else if (c == '\t') {
            return "\\t";
        } 
        else if (c == '\b') {
            return "\\b";
        } 
        else if (c == '\r') {
            return "\\r";
        } 
        else if (c == '\f') {
            return "\\f";
        } 
        else if (c == '\\') {
            return "\\\\";
        } 
        else if (c == '\'') {
            return "\\'";
        } 
        else if (c == '\"') {
            return "\\\"";
        } 
        else {
            return String.valueOf(c);
        }
	}
	
	public static void main(String[] args) {
		System.out.println("abc\\\"123");
		System.out.println(esToString("abc\\\"123"));
	}
}
