package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;

public class AnnotationEx1 {
	public static void main(String[] args) throws Exception {
		Class clz = TestUnit.class;
		
		TestUnit unit = new TestUnit();
		
		TreeMap<Integer, Method> map = new TreeMap<Integer, Method>(); // reflection���.
		
		for (Method m : clz.getDeclaredMethods()) { // method�鿡 ���� meta������ ������ using Annotation
			if (m.isAnnotationPresent(Test.class)) {
				Test test = m.getAnnotation(Test.class);
				map.put(test.value(), m);
//				boolean result = (boolean)m.invoke(unit);
//				String methodName = m.getName();
//				System.out.println(methodName+" �޼ҵ��� ������: "+(result?"����":"����"));
			}
		}
		
		for (Method m : map.values()) { // method�鿡 ���� annotaion�� ������� ����.
			boolean result = (boolean)m.invoke(unit);
			String methodName = m.getName();
			System.out.println(methodName+" �޼ҵ��� ������: "+(result?"����":"����"));
		}
	}
}

@Target(ElementType.METHOD) // Annotation Type����
@Retention(RetentionPolicy.RUNTIME)
@interface Test { // annotation ����
	int value(); // value�� �⺻ ����.
}

class TestUnit {
	@Test(2)
	public boolean testCase1() {
		return true;
	}
	

	@Test(1)
	public boolean testCase3() {
		return false;
	}
	
	
	public boolean testCase4() {
		return true;
	}
	
	@Test(3)
	public boolean testCase5() {
		return true;
	}
	
//	public boolean testCase2() { // �ּ�ó���ϴ� ��ſ� annotation�� ����Ͽ� �ʿ��Ѱ͸� ����.
//	return true;
//}
}