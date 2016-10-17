package api;

public class ObjectEx1 {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		
		System.out.println(s1 == s2); // compare address of val
		System.out.println(s1.equals(s2)); // compare val of two para.
		
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		System.out.println();
		System.out.println(mc1 == mc2);
		System.out.println(mc1.equals(mc2)); // compare val of two para.
		
		System.out.println(mc1); // same with System.out.println(mc1.toString());
		System.out.println(mc2.toString());
	}
}

class MyClass {
	private int val;
	MyClass(int val) {
		this.val = val;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof MyClass) {
			if (val == ((MyClass)obj).val) {
				return true;
			} 
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "val= "+val;
	}
}