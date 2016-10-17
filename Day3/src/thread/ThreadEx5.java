package thread;

public class ThreadEx5 {
	public static void main(String[] args) throws Exception {
		//�񵿱� ó��. Parallely
		MyUtil2 u1 = new MyUtil2(400, new MyUtil2.ResultHandler() {
			@Override
			public void complete(int result) { // interface(=abstract) method�� �������ؼ� ����Ѵ�.
				System.out.println("�հ�1:"+result); // System.out.println(u1.doLongWork());
			}
		});
		
		MyUtil2 u2 = new MyUtil2(100, new MyUtil2.ResultHandler() {
			@Override
			public void complete(int result) { // interface(=abstract) method�� �������ؼ� ����Ѵ�.
				System.out.println("�հ�2:"+result); // System.out.println(u2.doLongWork());				
			}
		});
		
		MyUtil2 u3 = new MyUtil2(200, (result)->{System.out.println("�հ�3:"+result);});
		
		u1.excute();
		u2.excute();
		u3.excute();
		
//		u2.join(); // u2�����尡 ����ɶ����� main �����带 ��ٸ��� ��. 
//		join()������ main�����Ŀ� u2�� ���������� �����.
		
	}
}

class MyUtil2 extends Thread{
	public interface ResultHandler {
		void complete (int result); // abstract method
	}
	
	ResultHandler handler;
	
	private int iteration; 
	
	MyUtil2(int iteration, ResultHandler handler) {
		this.iteration = iteration;
		this.handler = handler;
	}
	
	public void excute() {
		this.start();
	}
	
	@Override
	public void run() {
		int sum = doLongWork();
		handler.complete(sum);
	}
	
	public int doLongWork() {
		int sum = 0;
		
		for (int i = 01;i <= iteration;i++) {
			sum += i;
			try {
				Thread.sleep(5); // ms
			} catch (InterruptedException e) {	} 
		}
		
		return sum;
	}
}