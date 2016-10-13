package lambda;

public class Step1 {
	public static void main(String[] args) {
		ArrayWork.printEvenNum();
		ArrayWork.print3thNum();
		ArrayWork.print3thNEven();
	}
}

class ArrayWork {
	interface FilterHandler {
		boolean test(int n);
	}
	
	static private int[] arr = {1, 5, 2, 8, 4, 7, 12, 65, 34, 9 };
	
	public static void printEvenNum() {
		for (int n : arr) { // type : collection
			if (n % 2 == 0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}
	
	public static void print3thNum() {
		for (int n : arr) { // type : collection
			if (n % 3 == 0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}
	
	public static void print3thNEven() {
		for (int n : arr) { // type : collection
			if (n % 3 == 0 && n % 2 == 0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}
}
