package api;

import java.util.regex.Pattern;

public class PatternEx1 {
	public static void main(String[] args) {
		String pattern = "(010|070|080)-\\d{3,4}-\\d{4}"; // pattern
		String telNo = "060-8054-5140";
		
		if (Pattern.matches(pattern, telNo))
			System.out.println(telNo+"�� ��ȿ�� ��ȭ��ȣ�Դϴ�.");
		else
			System.out.println(telNo+"�� �߸��� ��ȭ��ȣ�Դϴ�.");
	}
}
