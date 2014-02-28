package ex16_05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

public class ClassContents {

	//ex16_05.Fooを引数とする
	//class ex16_05.Foo
	//public ex16_05.Foo()
	//@ex16_05.BugsFixed(value=[45678, 43246])

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(c.getFields());
			printMembers(c.getConstructors());
			printMembers(c.getMethods());
			printAnnotations(c.getAnnotations());
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	private static void printMembers(Member[] mems) {
		for (Member m: mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.println(" ");
			System.out.println(strip(decl, "java.lang."));
		}
	}
	private static void printAnnotations(Annotation[] ano) {
		for(Annotation printAno: ano)
			System.out.println(printAno.toString());
	}
	private static String strip (String decl, String removeStr) {
		
		return decl.replaceFirst(removeStr, "");
		
	}
}
