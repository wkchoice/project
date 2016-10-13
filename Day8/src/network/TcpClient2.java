package network;

	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.net.Socket;

public class TcpClient2 {
	 public static void main(String[] args) throws Exception {
	  Student2 stud = new Student2("홍길동", "대한민국");
	  Socket socket = new Socket("127.0.0.1", 5555);

	  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	  ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

	  System.out.println(">> 서버로 다음 데이터를 보냅니다.");
	  System.out.println(stud);
	  oos.writeObject(stud);
	  oos.flush();

	  Student2 stud2 = (Student2)ois.readObject();
	  System.out.println(">> 다음은 서버로부터 받은 객체 데이터입니다.");
	  System.out.println(stud2);

	  ois.close();
	  oos.close();
	 }
	}


