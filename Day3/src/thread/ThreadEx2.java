package thread;

public class ThreadEx2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread2("A"));
		Thread t2 = new Thread(new MyThread2("B"));
		Thread t3 = new Thread(new MyThread2("C"));
		//Runnable t4 = new MyThread2("D");
		
		t1.start(); // ������ ����
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
		// ������� ������ �ڵ�� �Է�
		for(int i=0;i<10;i++){
			System.out.print(name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}

}