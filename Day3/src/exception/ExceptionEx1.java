package exception;

import java.text.MessageFormat;
import java.util.Scanner;

public class ExceptionEx1 {
	public static void main(String[] args) {
		try {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 숫자: ");
		String s1 = scanner.nextLine();
		System.out.print("두번째 숫자:");
		String s2 = scanner.nextLine();
		
		int v1 = Integer.parseInt(s1);
		int v2 = Integer.parseInt(s2);
		
		int result = v1 / v2;
		
		System.out.println(MessageFormat.format("{0} 나누기 {1}는 {2}입니다.", v1, v2, result));
		
//		} catch(NumberFormatException e) {
//			System.out.println("숫자로 바꿀 수 없습니다.");
//		} catch(ArithmeticException e) {
//			System.out.println("0으로 나눌 수 없습니다.");
//		} catch(Exception e) {
//			System.out.println("알 수 없는 오류가 발생하였습니다.");
//		}
		} catch(NumberFormatException | ArithmeticException e) { // java 8에 추가된 표현식
			System.out.println("알 수 없는(Number,Arithmetic) 오류가 발생하였습니다.(On java 8)");
		}
		
	}
}
