package network4;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.Socket;
	import java.net.UnknownHostException;
	 
	public class TcpClient4 {
	    public static void main(String[] args) {
	        Socket socket = null;
	 
	        BufferedReader bufferedReader = null;
	        BufferedReader bufferedReaderFromServer = null;
	        PrintWriter printWriter = null;
	        try {
	            socket = new Socket("127.0.0.1", 1818);
	            bufferedReader = new BufferedReader(
	                    new InputStreamReader(System.in));
	 
	            printWriter = new PrintWriter(socket.getOutputStream());
	            bufferedReaderFromServer = new BufferedReader(
	                    new InputStreamReader(socket.getInputStream()));
	 
	            while(true){
	                System.out.print("�޼����� �Է��Ͻÿ� : ");
	                String str = bufferedReader.readLine();
	                if(str == null){
	                    System.out.println("\nbye bye~");
	                    System.out.println("������ ������ ���������ϴ�.");
	                    break;
	                }
	                printWriter.println(str);
	                printWriter.flush();
	                 
	                 
	                String strFromServer = bufferedReaderFromServer.readLine();
	                 
	                System.out.println("������ ���� ���� �޼��� : " + strFromServer);
	                 
	            }
	 
	        } catch (UnknownHostException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
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
	            if (bufferedReaderFromServer != null) {
	                try {
	                    bufferedReaderFromServer.close();
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

