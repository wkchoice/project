package exception;

public class ExceptionEx2 {
	public static void main(String[] args) {
		m1();
	}
	
	static void m1() {
		try {
			m2();
		} catch (InterruptedException e) {

		}
	}
	
	static void m2() throws InterruptedException {
		m3();
	}
	
	static void m3() throws InterruptedException {
		int i = 10 /0;
		Thread.sleep(1000);
	}
}
