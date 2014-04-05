package Interpret;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

class Interpret {
	public Object obj;
	public Object[] objArr;
	public Class<?> cls;
	public Class<?> clsArr;

	class FieldSet {
		public final Field member;
		public final String name;
		String fullName;
		public final Type type;
		public final Object value;

		private FieldSet(Field member, Type type, String name, Object value) {
			this.member = member;
			this.name = name;
			this.type = type;
			this.value = value;

			fullName = member.toString();
		}

		public String toString() {
			return fullName;
		}

		public Object getValue() {
			return value;
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

	Interpret(String name) throws ClassNotFoundException {
		cls = Class.forName(name);

	}
	
	Interpret(Class<?> cls) {
		this.cls = cls;

	}

	// 配列用
	Interpret() {

	}

	public Constructor<?>[] getConstructor() {
		Constructor<?>[] cons = cls.getConstructors();
		return cons;
	}

	public FieldSet[] getFieldSet() throws IllegalArgumentException,
			IllegalAccessException {
		Field[] fields = cls.getDeclaredFields();
		FieldSet[] fSet = new FieldSet[fields.length];
		for (int i = 0; i < fields.length; i++) {
			boolean isAccessible = fields[i].isAccessible();
			fields[i].setAccessible(true);
			fSet[i] = new FieldSet(fields[i], fields[i].getGenericType(),
					fields[i].getName(), fields[i].get(obj));
			fields[i].setAccessible(isAccessible);
		}

		return fSet;
	}

	public void setField(FieldSet fieldSet, Object value)
			throws SecurityException, IllegalArgumentException,
			IllegalAccessException {
		Field f = fieldSet.member;
		boolean isAccessible = f.isAccessible();
		f.setAccessible(true);
		f.set(obj, value);
		f.setAccessible(isAccessible);
	}

	public MethodSet[] getMethods(){
		Method[] methods = cls.getMethods();
		MethodSet[] mSet = new MethodSet[methods.length];

		for (int i = 0; i < methods.length; i++) {
			mSet[i] = new MethodSet(methods[i],
					methods[i].getGenericReturnType(), methods[i].getName(),
					methods[i].getParameterTypes());
		}

		return mSet;
	}
	
	public MethodSet[] getMethodsArr(){
		Method[] methods = clsArr.getMethods();
		MethodSet[] mSet = new MethodSet[methods.length];

		for (int i = 0; i < methods.length; i++) {
			mSet[i] = new MethodSet(methods[i],
					methods[i].getGenericReturnType(), methods[i].getName(),
					methods[i].getParameterTypes());
		}

		return mSet;
	}

	public void createCons(Constructor<?> constructor, Object[] argObj)
			throws IllegalArgumentException, InstantiationException,
			IllegalAccessException, IllegalAccessException,
			InvocationTargetException {
		Object[] args = new Object[argObj.length];
		for (int i = 0; i < argObj.length; i++)
			args[i] = argObj[i];
		obj = constructor.newInstance(args);
	}

	public void createArr(int numArr) {
			objArr = (Object[])Array.newInstance(cls, numArr);
			clsArr = objArr.getClass();
	}

	public Object runMethod(Method method, Object[] argObj)
			throws SecurityException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, Exception {
		Object returnValue = null;
		Object[] args = new Object[argObj.length];

		boolean isAccessible = method.isAccessible();
		method.setAccessible(true);
		for (int i = 0; i < argObj.length; i++)
			args[i] = argObj[i];

		returnValue = method.invoke(obj, args);
		method.setAccessible(isAccessible);

		return returnValue;
	}
	
	public Object runMethodArr(Method method, Object[] argObj)
			throws SecurityException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, Exception {
		Object returnValue = null;
		Object[] args = new Object[argObj.length];

		boolean isAccessible = method.isAccessible();
		method.setAccessible(true);
		for (int i = 0; i < argObj.length; i++)
			args[i] = argObj[i];

		returnValue = method.invoke(objArr, args);
		method.setAccessible(isAccessible);

		return returnValue;
	}

	public Object getObject() {
		return obj;
	}
}
