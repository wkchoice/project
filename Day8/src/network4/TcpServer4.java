package network4;

	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;

//	입력한 메세지를 서버로부터 다시 입력받아 출력하는 프로그램을 작성
//	- 입력한 메세지를 서버로 전송하여 서버로부터 메세지를 다시 되돌려받아 화면에 출력
//	- 여러 client가 접속하여 메세지를 입력하여도 정상 수행 되도록 해야함
//	- client에서 ctrl + z를 누르면 프로그램 종료
//
//	2012/04/03 - [Programing/JAVA] - Network Programming - 연습 3 : 입력한 메세지를 서버로부터 다시 돌려받는 프로그램 작성
//
//	Server
//	Thread 1
//	1. 서버소켓을 통해 새로운 소켓을 만든다.
//	2. 소켓이 만들어질 때마다 Thread 2를 생성하고 소켓을 Thread 2에 넘겨준다.
//
//	Thread 2
//	1. Thread 1로부터 넘겨받은 소켓을 통해 입/출력 노드를 받아옴
//	2. 노드에 적합한 필터를 붙여줌
//	3. 클라이언트로부터 메세지를 입력받은 후 다시 클라이언트로 메세지를 출력
//	4. 3을 반복
//	5. 클라이언트와 연결이 종료되면 연결을 해제
//
//	Client
//	1. 서버에 접속할 소켓 생성
//	2. 소켓으로부터 입/출력 노드를 받아옴
//	3. 노드에 적합한 필터를 붙여줌
//	4. 시스템으로부터 입력을 받아 서버에 전송
//	5. 서버로부터 메세지를 입력받아 화면에 출력
//	6. 4~5를 반복
//	7. ctrl + z가 눌리면 종료
//	8. 연결해제

	public class TcpServer4 {
		public final static int PORT = 1818;
		public static void main(String[] args) {
	        /*
	         * ServerSocket 생성
	         * Client 연결 대기 -> Socket 생성
	         * ServerThread를 start
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
