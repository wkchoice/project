package network;

	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.net.ServerSocket;
	import java.net.Socket;


	public class TcpServer2 extends Thread {
	 public static void main(String[] args) throws Exception {
	  ServerSocket serverSocket = new ServerSocket(5555);

	  System.out.println(">> Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�.");
	  Socket socket = serverSocket.accept();
	  System.out.println(">> Ŭ���̾�Ʈ ����: " + socket);

	  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	  ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

	  Student2 stud = (Student2)ois.readObject();

	  System.out.println(">> ������ Ŭ���̾�Ʈ�κ��� ���� ��ü �������Դϴ�.");
	  System.out.println(stud);

	  oos.writeObject(stud);
	  oos.flush();

	  oos.close();
	  ois.close();
	 }
	}
