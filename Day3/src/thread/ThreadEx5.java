package thread;

public class ThreadEx5 {
	public static void main(String[] args) throws Exception {
		//비동기 처리. Parallely
		MyUtil2 u1 = new MyUtil2(400, new MyUtil2.ResultHandler() {
			@Override
			public void complete(int result) { // interface(=abstract) method을 재정의해서 사용한다.
				System.out.println("합계1:"+result); // System.out.println(u1.doLongWork());
			}
		});
		
		MyUtil2 u2 = new MyUtil2(100, new MyUtil2.ResultHandler() {
			@Override
			public void complete(int result) { // interface(=abstract) method을 재정의해서 사용한다.
				System.out.println("합계2:"+result); // System.out.println(u2.doLongWork());				
			}
		});
		
		MyUtil2 u3 = new MyUtil2(200, (result)->{System.out.println("합계3:"+result);});
		
		u1.excute();
		u2.excute();
		u3.excute();
		
//		u2.join(); // u2쓰레드가 종료될때까지 main 쓰레드를 기다리게 함. 
//		join()없으면 main종료후에 u2는 독립수행후 종료됨.
		
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