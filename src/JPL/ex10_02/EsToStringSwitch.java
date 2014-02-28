package ex10_02;

public class EsToStringSwitch {
	static String esToString(String str) {
		StringBuffer changeStr = new StringBuffer(str.length());

		for (int i = 0; i < str.length(); i++)
			changeStr.append(changeEs(str.charAt(i)));
		return changeStr.toString();
	}

	static String changeEs(char c) {
		switch (c) {
		case '\n':
			return "\\n";
		case '\t':
			return "\\t";
		case '\b':
			return "\\b";
		case '\r':
			return "\\r";
		case '\f':
			return "\\f";
		case '\\':
			return "\\\\";
		case '\'':
			return "\\'";
		case '\"':
			return "\\\"";
		default:
			return String.valueOf(c);
		}
	}

	public static void main(String[] args) {
		System.out.println(esToString("abc123\""));
	}
}
