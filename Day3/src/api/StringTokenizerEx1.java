package api;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {
	public static void main(String[] args) {
		String fruits = "���,��,��,�ٳ���,����,Ű��,�޷�,����";
		
//		String[] words = fruits.split(","); // delimeter(�и���)
		StringTokenizer tokenizer = new StringTokenizer(fruits, ","); // split�� ������ ���
		
		while(tokenizer.hasMoreTokens()) {
			String f = tokenizer.nextToken();
			System.out.println(f);
		}
	}
}
