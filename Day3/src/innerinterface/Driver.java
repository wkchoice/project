package innerinterface;

public class Driver {
	public static void main(String[] args) {
		int interval = 3;
		Timer t1 = new Timer(interval);
//		t1.setTimerHandler(new MyClass(interval)); // �����ڸ� �̿�
		
//		t1.setTimerHandler(new Timer.TimerHandler() {
//			@Override
//			public void onTime() {
//				System.out.println(interval+"�ʰ� ����Ͽ� ���� �ݽ��ϴ�.(override�̿�");
//			}
//		});
		
		t1.setTimerHandler( ()->{ System.out.println(interval + "�ʰ� ����Ͽ� ��ź�� �����ϴ�.(���ٽ� �̿�)"); } );
		
		t1.Start();
	}
}
 
class MyClass implements Timer.TimerHandler {
	private int interval;
	
	MyClass(int interval) {
		this.interval = interval;
	}
	
	@Override
	public void onTime() {
		System.out.println(interval +"�ʰ� ����Ͽ� ���� ���� ���ϴ�.(������ �̿�)");
	}
	
}