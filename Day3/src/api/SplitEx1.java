package api;

public class SplitEx1 {
	public static void main(String[] args) {
		String fruits = "사과,배,귤,바나나,딸기,키워,메론,망고";
		
		String[] words = fruits.split(","); // delimeter(분리자)
		
		for(String f : words) {
		    System.out.println(f);
		}
	}
}
