package networkdb;

import java.awt.Transparency;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//server ends up when receive Ctrl+z
//server receiving from multi clients and send the received message to each client( unlimited times) TcpServer4
public class TcpServer0 {
	public final static int port = 50005;
	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;
		Socket s = null; 
		try {
			ss = new ServerSocket(port);
			while ((s = ss.accept()) != null) {
				Thread t = new Thread(new TcpServerThread0(s));
				t.setDaemon(true);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ss != null) ss.close();
	}
}


//server ends up after receiving from client and send the received message to client( just 1 times) TcpServer3
//ServerSocket serverSocket = null;
//Socket socket = null;
//serverSocket = new ServerSocket(1818);
//while (true) {
//	BufferedReader bufferedReader = null;
//	PrintWriter printWriter = null;
//	try {
//		socket = serverSocket.accept();
//
//		bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//		String str = bufferedReader.readLine();
//		System.out.println("Client로 부터 받은 메세지 : " + str);
//
//		printWriter = new PrintWriter(socket.getOutputStream());
//
//		printWriter.println(str);
//		printWriter.flush();
//
//	} catch (IOException e) {
//	} finally {
//		if (bufferedReader != null) {
//			try {
//				bufferedReader.close();
//			} catch (IOException e) {}
//		}
//
//		if (printWriter != null) {
//			printWriter.close();
//		}
//
//		if (socket != null) {
//			try {
//				socket.close();
//			} catch (IOException e) {}
//		}
//	}
//}


//server ends up after receiving from client and display the received message ( just 1 times) Tcpserve2
//ServerSocket serverSocket = new ServerSocket(5555);
//Socket socket = serverSocket.accept();
//
//ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//
//Student2 stud = (Student2)ois.readObject();
//System.out.println(">> 다음은 클라이언트로부터 받은 객체 데이터입니다.");
//System.out.println(stud);
//
//oos.writeObject(stud);
//oos.flush();
//
//oos.close();
//ois.close()