package network;

	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.net.Socket;

public class TcpClient2 {
	 public static void main(String[] args) throws Exception {
	  Student2 stud = new Student2("ȫ�浿", "���ѹα�");
	  Socket s = new Socket("127.0.0.1", 5555);

	  ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
	  ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

	  System.out.println(">> ������ ���� �����͸� �����ϴ�.");
	  System.out.println(stud);
	  oos.writeObject(stud);
	  oos.flush();

	  Student2 stud2 = (Student2)ois.readObject();
	  System.out.println(">> ������ �����κ��� ���� ��ü �������Դϴ�.");
	  System.out.println(stud2);

	  ois.close();
	  oos.close();
	 }
	}


