package network4;

	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;

//	�Է��� �޼����� �����κ��� �ٽ� �Է¹޾� ����ϴ� ���α׷��� �ۼ�
//	- �Է��� �޼����� ������ �����Ͽ� �����κ��� �޼����� �ٽ� �ǵ����޾� ȭ�鿡 ���
//	- ���� client�� �����Ͽ� �޼����� �Է��Ͽ��� ���� ���� �ǵ��� �ؾ���
//	- client���� ctrl + z�� ������ ���α׷� ����
//
//	2012/04/03 - [Programing/JAVA] - Network Programming - ���� 3 : �Է��� �޼����� �����κ��� �ٽ� �����޴� ���α׷� �ۼ�
//
//	Server
//	Thread 1
//	1. ���������� ���� ���ο� ������ �����.
//	2. ������ ������� ������ Thread 2�� �����ϰ� ������ Thread 2�� �Ѱ��ش�.
//
//	Thread 2
//	1. Thread 1�κ��� �Ѱܹ��� ������ ���� ��/��� ��带 �޾ƿ�
//	2. ��忡 ������ ���͸� �ٿ���
//	3. Ŭ���̾�Ʈ�κ��� �޼����� �Է¹��� �� �ٽ� Ŭ���̾�Ʈ�� �޼����� ���
//	4. 3�� �ݺ�
//	5. Ŭ���̾�Ʈ�� ������ ����Ǹ� ������ ����
//
//	Client
//	1. ������ ������ ���� ����
//	2. �������κ��� ��/��� ��带 �޾ƿ�
//	3. ��忡 ������ ���͸� �ٿ���
//	4. �ý������κ��� �Է��� �޾� ������ ����
//	5. �����κ��� �޼����� �Է¹޾� ȭ�鿡 ���
//	6. 4~5�� �ݺ�
//	7. ctrl + z�� ������ ����
//	8. ��������

	public class TcpServer4 {
		public final static int PORT = 1818;
		public static void main(String[] args) {
	        /*
	         * ServerSocket ����
	         * Client ���� ��� -> Socket ����
	         * ServerThread�� start
	         */
	         
	        ServerSocket serverSocket = null;
	         
	        try {
	            serverSocket = new ServerSocket(PORT);
	            while(true){
	                Socket socket = serverSocket.accept();
	                 
	                if(socket != null){
	                    Thread thread = new Thread(new ServerThread4(socket));
	                    thread.start();
	                }
	            }
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	         
	         
	    }
	}
