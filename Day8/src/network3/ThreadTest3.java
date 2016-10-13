package network3;

public class ThreadTest3 {
//	1�ʸ��� ������ �����ϴ� Thread�� 20�ʸ��� ������ ������ �̵��ϴ� Thread�� ����� ����
//	Thread 1
//	- 1�ʸ��� ������ ���� (~~.1, ~~.2 ....)
//
//	Thread 2 
//	- 20�ʸ��� ������ �̵� (Thread 1���� ������ ��� ���ϵ��� �ٸ� ��η� �̵�)
//
//	Thread 1
//	1. ���� ��ü�� �����Ͽ� ���ο� ������ ����
//	2. 1�ʰ� �޽�
//
//	Thread 2
//	1. ���� ��ü�� ����
//	2. ������ ���ο� ��η� �̵�
//	3. ������ �������� ���������� 1~2�� �ݺ�
//	4. 20�ʰ� �޽�

	    public static void main(String[] args) {
	        Thread makeFileThread = new Thread(new MakeFileThread3());
	        Thread moveFileThread = new Thread(new MovieFileThread3());
	 
	        makeFileThread.start();
	        moveFileThread.start();
	    }
	}
