package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx1 {
	public static void main(String[] args) {
//		for (int i=1;i<=10;i++) {
//			Thread t = new Thread(new MyClass("객체"+i));
//			t.start(); // 쓰레드 시작
//		}
		
		ExecutorService pool = Executors.newFixedThreadPool(4); // 4개 Thread생성
		
		for (int i=1;i<=10;i++) {
			pool.execute(new MyClass("객 체"+i));
		}
		
		System.out.println("main 메소드가 종료됩니다.");
		
		// pool.shutdownNow();
	}
}

class MyClass implements Runnable {
	private String name;
	
	MyClass(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		int sum = 0, iteration = 100;
		
		for (int i = 01;i <= iteration;i++) {
			sum += i;
			try {
				Thread.sleep(10); // ms
			} catch (InterruptedException e) {
			} 
		}
		
		System.out.println(name+"의 결과값: "+sum);
	}
	
}