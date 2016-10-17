package exception;

public class ExceptionEx3 {
	public static void main(String[] args) {
		MyClass m1 = null;
		
		try {
			m1 = new MyClass();
		} catch(Exception e) {

		} finally {
			if (m1 != null)
				m1.close();
		}
		System.gc(); // garbage collector
		
		//
		try(MyClass m2 = new MyClass()) { // implements AutoCloseable로 선언됨.
			System.out.println("AutoCloseable");
		}
		
		//
		m1 = null;
		
		System.gc();
		
		for (int i = 0; i < 10000;i++) {
			try (MyClass m2 = new MyClass()) {
				
			}
		}
		
		
	}
}

class MyClass implements AutoCloseable {
	@Override
	protected void finalize() throws Throwable { // garbage collector
		System.out.println("객체가 제거되었습니다");
	};
	
	public void close() {
		System.out.println("마무리 작업을 합니다.");
	}
}
