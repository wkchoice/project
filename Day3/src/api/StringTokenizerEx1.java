package api;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {
	public static void main(String[] args) {
		String fruits = "사과,배,귤,바나나,딸기,키워,메론,망고";
		
//		String[] words = fruits.split(","); // delimeter(분리자)
		StringTokenizer tokenizer = new StringTokenizer(fruits, ","); // split과 동일한 결과
		
		while(tokenizer.hasMoreTokens()) {
			String f = tokenizer.nextToken();
			System.out.println(f);
		}
	}
}
