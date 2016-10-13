package network3;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.ServerSocket;
	import java.net.Socket;

//	�Է��� �޼����� ������ �����Ͽ� ������ �ֿܼ� ���� �ٽ� �����޾� Ŭ���̾�Ʈ�� �ֿܼ� ���� ���α׷�
//
//	Server
//	1. Client�� Server�� ������ �� �ֵ��� ����
//	2. Client�� ���� �޼����� �޾� ȭ�鿡 ���
//	3. ���� �޼����� Client�� ����
//	4. ���� ����
//
//	Client
//	1. ������ �����Ѵ�.
//	2. Ű����� ���� �Է��� �޴´�.
//	3. ���� �޼����� ������ ������.
//	4. �������� �޼����� �� ������ ��ٸ� �� �޼����� �޾� ȭ�鿡 ����Ѵ�.
//	5. ��������

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
	                System.out.println("Client�� ���� ���� �޼��� : " + str);
	 
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
