package network3;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.ServerSocket;
	import java.net.Socket;

//	입력한 메세지를 서버에 전송하여 서버의 콘솔에 띄우고 다시 돌려받아 클라이언트의 콘솔에 띄우는 프로그램
//
//	Server
//	1. Client가 Server에 접속할 수 있도록 구성
//	2. Client로 부터 메세지를 받아 화면에 출력
//	3. 받은 메세지를 Client로 전송
//	4. 연결 해제
//
//	Client
//	1. 서버와 연결한다.
//	2. 키보드로 부터 입력을 받는다.
//	3. 받은 메세지를 서버로 보낸다.
//	4. 서버에서 메세지가 올 때까지 기다린 후 메세지를 받아 화면에 출력한다.
//	5. 연결해제

	public class TcpServer3 {
	    public static void main(String[] args) {
	        ServerSocket serverSocket = null;
	        Socket socket = null;
	 
	        try {
	            serverSocket = new ServerSocket(1818);
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	         
	        while (true) {
	            BufferedReader bufferedReader = null;
	            PrintWriter printWriter = null;
	            try {
	                socket = serverSocket.accept();
	 
	                bufferedReader = new BufferedReader(new InputStreamReader(
	                        socket.getInputStream()));
	 
	                String str = bufferedReader.readLine();
	                System.out.println("Client로 부터 받은 메세지 : " + str);
	 
	                printWriter = new PrintWriter(socket.getOutputStream());
	 
	                printWriter.println(str);
	                printWriter.flush();
	 
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } finally {
	                if (bufferedReader != null) {
	                    try {
	                        bufferedReader.close();
	                    } catch (IOException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	                if (printWriter != null) {
	                    printWriter.close();
	                }
	                if (socket != null) {
	                    try {
	                        socket.close();
	                    } catch (IOException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            }
	 
	        }
	    }
	}
