package api;

public class SplitEx1 {
	public static void main(String[] args) {
		String fruits = "���,��,��,�ٳ���,����,Ű��,�޷�,����";
		
		String[] words = fruits.split(","); // delimeter(�и���)
		
		for(String f : words) {
		    System.out.println(f);
		}
	}
}
