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
		
		// lambda �� : interace�� (argument�� 1�� �ΰ�츸 �ش�)�� ���� ��������.
		ArrayWork2.printFilteredNum(n -> ( n % 2 == 1) ); // interface�� argument�� �̹� �˰� �����Ƿ� type ���� ����
	
	}
}

class ArrayWork2 {
	interface FilterHandler {
		boolean test(int n);
		
		// ���� FilterHandler�� implements�� test(n)�� ��밡���ϰ�, 
		// ���Ӱ� FilterHandler�� implements�� newTest(n)�� ��� ������.
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