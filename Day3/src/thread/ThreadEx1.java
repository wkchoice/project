package thread;

public class ThreadEx1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread("A");
		Thread t2 = new MyThread("B");
		Thread t3 = new MyThread("C");
		Thread t4 = new MyThread("D");
		
		t1.start(); // ������ ����
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
		// ������� ������ �ڵ�� �Է�
		for(int i=0;i<10;i++){
			System.out.print(name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
	
	// ������ ��� : listener�뵵(network server), �񵿱� ó��(Async) //
}