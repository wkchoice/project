package api;

public class WrapperEx1 {
	public static void main(String[] args) {
		Emp e1 = new Emp();
		
		e1.bonus = 1000000;
		int bonus = e1.bonus;
		System.out.println(e1.bonus);
	}
}

class Emp {
	String empNo;
	String name;
//	int bonus; // primitive
	Integer bonus; // refer class in class(°´Ã¼)
}