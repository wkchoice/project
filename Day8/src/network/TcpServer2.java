package network;

	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.net.ServerSocket;
	import java.net.Socket;


	public class TcpServer2 extends Thread {
	 public static void main(String[] args) throws Exception {
	  ServerSocket serverSocket = new ServerSocket(5555);

	  System.out.println(">> 클라이언트의 접속을 기다립니다.");
	  Socket socket = serverSocket.accept();
	  System.out.println(">> 클라이언트 접속: " + socket);

	  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	  ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

	  Student2 stud = (Student2)ois.readObject();

	  System.out.println(">> 다음은 클라이언트로부터 받은 객체 데이터입니다.");
	  System.out.println(stud);

	  oos.writeObject(stud);
	  oos.flush();

	  oos.close();
	  ois.close();
	 }
	}
