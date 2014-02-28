package ex16_04;

import java.lang.annotation.Annotation;
public class PrintAnnotation {
	//ex16_05.Fooを引数とする
	//@ex16_05.BugsFixed(value=[45678, 43246])

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			Annotation[] ano = c.getAnnotations();
			for(Annotation printAno: ano)
				System.out.println(printAno.toString());
		} catch(ClassNotFoundException e) {
			System.err.println("unknown class:" + args[0]);
		}
		
	}

}
