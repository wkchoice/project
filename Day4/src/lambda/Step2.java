package lambda;

public class Step2 {
	public static void main(String[] args) {
		ArrayWork2.printFilteredNum(new ArrayWork2.FilterHandler() {
			@Override
			public boolean test(int n) {
				return ((n % 2) == 0);
			}
		} );
	
		ArrayWork2.printFilteredNum(new ArrayWork2.FilterHandler() {
			@Override
			public boolean test(int n) {
				return (n % 2 == 0 && n % 3 == 0);
			}
		} );
		
		// lambda 식 : interace의 (argument가 1개 인경우만 해당)를 위해 재정의함.
		ArrayWork2.printFilteredNum(n -> ( n % 2 == 1) ); // interface의 argument는 이미 알고 있으므로 type 생략 가능
	
	}
}

class ArrayWork2 {
	interface FilterHandler {
		boolean test(int n);
		
		// 기존 FilterHandler를 implements한 test(n)도 사용가능하고, 
		// 새롭게 FilterHandler를 implements한 newTest(n)도 사용 가능함.
		default boolean newTest(int n) { 
//			System.out.println(test(n));
			return (test(n));
		}
	}
	
	static private int[] arr = {1, 5, 2, 8, 4, 7, 12, 65, 34, 9 };
	
	public static void printFilteredNum(FilterHandler handler) {
		for (int n : arr) { // type : collection
			if (handler.test(n)) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}
}