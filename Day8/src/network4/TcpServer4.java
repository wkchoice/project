package network4;

	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;
	 
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
