package api;

public class TimerTest {
	public static void main(String[] args) {
		String s1 = "";
		
		long from = System.currentTimeMillis();
		for(int i =0;i < 30000;i++) {
			s1 +="abcd";
		}
		long to = System.currentTimeMillis();
		
		System.out.println("문자열의 길이:"+s1.length());
		System.out.println("소요시간(성능감소):"+(to-from)+"ms");
		
		//
		StringBuilder sb = new StringBuilder();
		from = System.currentTimeMillis();
		for(int i =0;i < 30000;i++) {
			sb.append("abcd");
		}
		to = System.currentTimeMillis();
		
		System.out.println("문자열의 길이:"+s1.length());
		System.out.println("소요시간(성능개선):"+(to-from)+"ms");
	}
}
