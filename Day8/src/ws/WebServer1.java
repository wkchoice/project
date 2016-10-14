package ws;


import java.net.ServerSocket;
import java.net.Socket;

/**
 * <pre>
 * �������� �����ϴ� Ŭ����
 * </pre>
 * 
 * @author eye
 * @since 2010.11.15
 */
class WebServer1
{
	public static void main(String argv[]) throws Exception
	{
		// ���������� �����Ѵ�. �������� �⺻������ 80�� ��Ʈ�� ����Ѵ�.
		ServerSocket listenSocket = new ServerSocket(80);
		System.out.println("WebServer Socket Created");

		Socket connectionSocket;
		ServerThread1 serverThread;
		
		// ��ȯ�� ���鼭 Ŭ���̾�Ʈ�� ������ �޴´�. accept()�� Blocking �޼����̴�.
		while((connectionSocket = listenSocket.accept()) != null)
		{
			// ���� �����带 �����Ͽ� �����Ѵ�.
			serverThread = new ServerThread1(connectionSocket);
			serverThread.start();
		}
	}
}

