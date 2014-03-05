package Interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

class Interpret {
	public Object obj;
	public Class<?> cls;
	private MethodSet[] methodSet;
	private ShowFrame showFrame;

	class FieldSet {
		public final Member member;
		public final String name;
		String fullName;
		public final Type type;
		public final Object value;

		private FieldSet(Member member, Type type, String name, Object value) {
			this.member = member;
			this.name = name;
			this.type = type;
			this.value = value;

			fullName = member.toString();
		}

		public String toString() {
			return fullName;
		}
	}

	class MethodSet {
		public final Member member;
		public final String name;
		String fullName;
		public final Type returnValue;
		public final Class<?>[] args;

		private MethodSet(Member member, Type returnValue, String name,
				Class<?>[] args) {
			this.member = member;
			this.name = name;
			this.returnValue = returnValue;
			this.args = args;

			fullName = member.toString();
		}

		public String toString() {
			return fullName;
		}
	}

	static String strip(String decl, String string) {
		String returnValue = decl;
		int start;
		while ((start = returnValue.indexOf(string)) != -1) {
			returnValue = returnValue.substring(0, start)
					+ returnValue.substring(start + string.length());
		}

		return returnValue;
	}

	Interpret(String name, ShowFrame ui) {
		this.showFrame = ui;
		try {
			cls = Class.forName(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public MethodSet[] getConstructor() {
		Constructor<?>[] consts = cls.getConstructors();
		MethodSet[] cSet = new MethodSet[consts.length];
		for (int i = 0; i < consts.length; i++) {
			cSet[i] = new MethodSet(consts[i], null, consts[i].getName(),
					consts[i].getParameterTypes());
		}
		return cSet;
	}

	public FieldSet[] getFieldSet() {
		Field[] fields = cls.getDeclaredFields();
		FieldSet[] fSet = new FieldSet[fields.length];
		for (int i = 0; i < fields.length; i++) {
			try {
				boolean isAccessible = fields[i].isAccessible();
				fields[i].setAccessible(true);
				fSet[i] = new FieldSet(fields[i], fields[i].getGenericType(),
						fields[i].getName(), fields[i].get(obj));
				fields[i].setAccessible(isAccessible);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return fSet;
	}

	public void setField(String name, Object value) {
		try {
			Field f = cls.getDeclaredField(name);
			boolean isAccessible = f.isAccessible();
			f.setAccessible(true);
			f.set(obj, value);
			f.setAccessible(isAccessible);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public MethodSet[] getMethods() {
		Method[] methods = cls.getMethods();
		MethodSet[] mSet = new MethodSet[methods.length];

		for (int i = 0; i < methods.length; i++) {
			try {
				boolean isAccessible = methods[i].isAccessible();
				methods[i].setAccessible(true);
				mSet[i] = new MethodSet(methods[i],
						methods[i].getGenericReturnType(),
						methods[i].getName(), methods[i].getParameterTypes());
				methods[i].setAccessible(isAccessible);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}

		return mSet;
	}

	public void createCons(Constructor<?> constructor, Object[] argObj) {
		try {
			Object[] args = new Object[argObj.length];
			for (int i = 0; i < argObj.length; i++)
				args[i] = argObj[i];
			obj = constructor.newInstance(args);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			showFrame.outputException(cause);
		}
	}

	public Object runMethod(Method method, Object[] argObj) {
		Object returnValue = null;
		try {
			Object[] args = new Object[argObj.length];

			boolean isAccessible = method.isAccessible();
			method.setAccessible(true);
			for (int i = 0; i < argObj.length; i++)
				args[i] = argObj[i];

			returnValue = method.invoke(obj, args);
			method.setAccessible(isAccessible);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			showFrame.outputException(cause);
		}

		return returnValue;
	}

	public Object getObject() {
		return obj;
	}
}
