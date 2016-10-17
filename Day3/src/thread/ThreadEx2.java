package thread;

public class ThreadEx2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread2("A"));
		Thread t2 = new Thread(new MyThread2("B"));
		Thread t3 = new Thread(new MyThread2("C"));
		//Runnable t4 = new MyThread2("D");
		
		t1.start(); // 쓰레드 시작
		t2.start();
		t3.start();
		//t4.start();
	}
}

class MyThread2 implements Runnable {

	private String name;
	
	MyThread2 (String name) {
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

}