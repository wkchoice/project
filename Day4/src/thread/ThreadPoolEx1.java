package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx1 {
	public static void main(String[] args) {
//		for (int i=1;i<=10;i++) {
//			Thread t = new Thread(new MyClass("��ü"+i));
//			t.start(); // ������ ����
//		}
		
		ExecutorService pool = Executors.newFixedThreadPool(4); // 4�� Thread����
		
		for (int i=1;i<=10;i++) {
			pool.execute(new MyClass("�� ü"+i));
		}
		
		System.out.println("main �޼ҵ尡 ����˴ϴ�.");
		
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
		
		System.out.println(name+"�� �����: "+sum);
	}
	
}