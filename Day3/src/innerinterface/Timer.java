package innerinterface;

import java.util.Iterator;

public class Timer {
	
	public interface TimerHandler {
		void onTime();
	}
	
	private TimerHandler handler; // handler�� ��ü�� ������ �ִ�.
	
	private int interval;
	
	public Timer(int interval) {
		this.interval = interval;
	}
	
	public void setTimerHandler(TimerHandler handler) {
		this.handler = handler;
	}
	
	public void Start() {
		for (int i = interval; i> 0; i--) {
			System.out.println(i+"�� ���ҽ��ϴ�..");
			try {
				Thread.sleep(1000);// sleep 1 second
			} catch (InterruptedException e) { } 
		}
		
		if (handler != null)
			handler.onTime();
	}
}