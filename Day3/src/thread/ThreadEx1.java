package thread;

public class ThreadEx1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread("A");
		Thread t2 = new MyThread("B");
		Thread t3 = new MyThread("C");
		Thread t4 = new MyThread("D");
		
		t1.start(); // 쓰레드 시작
		t2.start();
		t3.start();
		t4.start();
	}
}

class MyThread extends Thread { // inheritance from Thread
	private String name;
	
	MyThread (String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		// 쓰레드로 수행할 코드들 입력
		for(int i=0;i<10;i++){
			System.out.print(name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	
	// 쓰레드 사용 : listener용도(network server), 비동기 처리(Async) //
}