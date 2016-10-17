package exception;

import java.text.MessageFormat;
import java.util.Scanner;

public class ExceptionEx1 {
	public static void main(String[] args) {
		try {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("ù��° ����: ");
		String s1 = scanner.nextLine();
		System.out.print("�ι�° ����:");
		String s2 = scanner.nextLine();
		
		int v1 = Integer.parseInt(s1);
		int v2 = Integer.parseInt(s2);
		
		int result = v1 / v2;
		
		System.out.println(MessageFormat.format("{0} ������ {1}�� {2}�Դϴ�.", v1, v2, result));
		
//		} catch(NumberFormatException e) {
//			System.out.println("���ڷ� �ٲ� �� �����ϴ�.");
//		} catch(ArithmeticException e) {
//			System.out.println("0���� ���� �� �����ϴ�.");
//		} catch(Exception e) {
//			System.out.println("�� �� ���� ������ �߻��Ͽ����ϴ�.");
//		}
		} catch(NumberFormatException | ArithmeticException e) { // java 8�� �߰��� ǥ����
			System.out.println("�� �� ����(Number,Arithmetic) ������ �߻��Ͽ����ϴ�.(On java 8)");
		}
		
	}
}
