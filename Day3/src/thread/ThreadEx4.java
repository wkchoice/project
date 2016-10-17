package thread;

public class ThreadEx4 {
	public static void main(String[] args) {
		//���� ó��:�������(serial�ϰ�) ������. 
		MyUtil u1 = new MyUtil(500);
		System.out.println(u1.doLongWork());
		MyUtil u2 = new MyUtil(100);
		System.out.println(u2.doLongWork());
		MyUtil u3 = new MyUtil(200);
		System.out.println(u3.doLongWork());
		
	}
}

class MyUtil {
	private int iteration; 
	
	MyUtil(int iteration) {
		this.iteration = iteration;		
	}
	
	public int doLongWork() {
		int sum = 0;
		
		for (int i = 01;i <= iteration;i++) {
			sum += i;
			try {
				Thread.sleep(5); // ms
			} catch (InterruptedException e) {
			} 
		}
		
		return sum;
	}
}