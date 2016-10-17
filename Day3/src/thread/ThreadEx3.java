package thread;

public class ThreadEx3 {
	public static void main(String[] args) throws Exception {
		Account account = new Account();
		
		Bankwork b1 = new Bankwork(account);
		Bankwork b2 = new Bankwork(account);
		Bankwork b3 = new Bankwork(account);
		
		b1.start(); // b1쓰레드 시작.
		b2.start(); // b2쓰레드 시작.
		b3.start(); // b3쓰레드 시작.
		long from = System.currentTimeMillis();
		
		b1.join(); // b1쓰레드가 종료될때까지 main 쓰레드를 기다리게 함.
		b2.join(); // b2쓰레드가 종료될때까지 main 쓰레드를 기다리게 함.
		b3.join(); // b3쓰레드가 종료될때까지 main 쓰레드를 기다리게 함.
//		long to = System.nanoTime();
		long to = System.currentTimeMillis();
		
		System.out.println("balance:"+account.getBalance());
		System.out.println("경과 시간: "+ (to-from)+" ms");
	}
}

class Bankwork extends Thread {
	private Account account;
	
	Bankwork(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		for (int i=1;i<=100000;i++) {
			account.deposit(i);
			account.withdraw(i);
		}
	}
}

class Account {
	private long balance; //잔액 
	private Object lock = new Object(); // 블록을 sync하는 방법

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	// method를 sync하는 방법
//	public synchronized void deposit(int amount) { //입금 synchronized:lock를 동작 시킴
//		balance = balance + amount;
//	}
//	
//	public synchronized void withdraw(int amount) { //출금 synchronized:lock를 동작 시킴
//		balance = balance - amount;
//	}
	
	// 블록을 sync하는 방법
	public void deposit(int amount) { //입금 synchronized:lock를 동작 시킴
		synchronized (lock) {
			balance = balance + amount;
		}
	}
	
	public void withdraw(int amount) { //출금 synchronized:lock를 동작 시킴
		synchronized (lock) {
			balance = balance - amount;
		}
	}
}