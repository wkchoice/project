package thread;

public class ThreadEx3 {
	public static void main(String[] args) throws Exception {
		Account account = new Account();
		
		Bankwork b1 = new Bankwork(account);
		Bankwork b2 = new Bankwork(account);
		Bankwork b3 = new Bankwork(account);
		
		b1.start(); // b1������ ����.
		b2.start(); // b2������ ����.
		b3.start(); // b3������ ����.
		long from = System.currentTimeMillis();
		
		b1.join(); // b1�����尡 ����ɶ����� main �����带 ��ٸ��� ��.
		b2.join(); // b2�����尡 ����ɶ����� main �����带 ��ٸ��� ��.
		b3.join(); // b3�����尡 ����ɶ����� main �����带 ��ٸ��� ��.
//		long to = System.nanoTime();
		long to = System.currentTimeMillis();
		
		System.out.println("balance:"+account.getBalance());
		System.out.println("��� �ð�: "+ (to-from)+" ms");
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
	private long balance; //�ܾ� 
	private Object lock = new Object(); // ����� sync�ϴ� ���

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	// method�� sync�ϴ� ���
//	public synchronized void deposit(int amount) { //�Ա� synchronized:lock�� ���� ��Ŵ
//		balance = balance + amount;
//	}
//	
//	public synchronized void withdraw(int amount) { //��� synchronized:lock�� ���� ��Ŵ
//		balance = balance - amount;
//	}
	
	// ����� sync�ϴ� ���
	public void deposit(int amount) { //�Ա� synchronized:lock�� ���� ��Ŵ
		synchronized (lock) {
			balance = balance + amount;
		}
	}
	
	public void withdraw(int amount) { //��� synchronized:lock�� ���� ��Ŵ
		synchronized (lock) {
			balance = balance - amount;
		}
	}
}