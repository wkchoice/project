package innerinterface;

public class Driver {
	public static void main(String[] args) {
		int interval = 3;
		Timer t1 = new Timer(interval);
//		t1.setTimerHandler(new MyClass(interval)); // 생성자를 이용
		
//		t1.setTimerHandler(new Timer.TimerHandler() {
//			@Override
//			public void onTime() {
//				System.out.println(interval+"초가 경과하여 문을 닫습니다.(override이용");
//			}
//		});
		
		t1.setTimerHandler( ()->{ System.out.println(interval + "초가 경과하여 폭탄이 터집니다.(람다식 이용)"); } );
		
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
		System.out.println(interval +"초가 경과하여 가스 불을 끕니다.(생성자 이용)");
	}
	
}