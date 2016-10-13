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
		
		TreeMap<Integer, Method> map = new TreeMap<Integer, Method>(); // reflection기능.
		
		for (Method m : clz.getDeclaredMethods()) { // method들에 대한 meta정보를 가져옴 using Annotation
			if (m.isAnnotationPresent(Test.class)) {
				Test test = m.getAnnotation(Test.class);
				map.put(test.value(), m);
//				boolean result = (boolean)m.invoke(unit);
//				String methodName = m.getName();
//				System.out.println(methodName+" 메소드의 수행결과: "+(result?"성공":"실패"));
			}
		}
		
		for (Method m : map.values()) { // method들에 대한 annotaion의 순서대로 동작.
			boolean result = (boolean)m.invoke(unit);
			String methodName = m.getName();
			System.out.println(methodName+" 메소드의 수행결과: "+(result?"성공":"실패"));
		}
	}
}

@Target(ElementType.METHOD) // Annotation Type선언
@Retention(RetentionPolicy.RUNTIME)
@interface Test { // annotation 정의
	int value(); // value는 기본 제공.
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
	
//	public boolean testCase2() { // 주석처리하는 대신에 annotation를 사용하여 필요한것만 동작.
//	return true;
//}
}