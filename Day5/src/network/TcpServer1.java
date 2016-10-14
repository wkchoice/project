package network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Date;
//import java.sql.Date;
import db.*;

public class TcpServer1 {
	public final static int PORT = 40005;
	
	public static void main(String[] args) throws IOException {
		// 1. ServerSocket ����.port. 40005 // 
		// WK-01 : ServerSocket sss = new ServerSocket(PORT);
		ServerSocket ss = new ServerSocket();
		ss.bind(new InetSocketAddress(PORT));
		
		System.out.println("Srv> ���� ���� �մϴ�."+(new Date()));
		Date curr_now;
		try {
			// WK-02 : below 
			while (true) {
				Socket socket = ss.accept(); //Ŭ���̾�Ʈ ���� ��û�� ���� ������ block��.
				
				// Send date to client
				// 2. I/O �۾�
				// 2-1. OutputStream �޾ƿ��� �� buffering
				OutputStream out = socket.getOutputStream();
				BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(out));
				
				// 2-2. �۾�
				curr_now = new Date();
				writer.write(curr_now+"\r\n");
				writer.flush();
				//System.out.println("���� �ð�(����)"+curr_now.toString());
				
				System.out.println("Srv> Ŭ���̾�Ʈ ����: "+socket.getRemoteSocketAddress()+", ���� �ð� - "+curr_now);
				// 3. Ŭ���̾�� ����.
				ClientService service = new ClientService(socket);
				service.setDaemon(true);
				service.start(); //  Start and run Thread
			}
		} catch (Exception e) { }
		
//		int buf_size = 1024;
//		byte[] buf = new byte[ buf_size ];
//		
//		//	outputstream : prog�� ������ stream(=data). server����
//		//	inputstream : prog�κ��� ������ stream(=data). server����
//		InputStream in = socket.getInputStream(); 
//		int byteReadCount = in.read(buf);
//		
//		String msg = new String(buf, 0, byteReadCount, "UTF-8");
//		System.out.println("���۸޽��� :"+msg);
//		
//		socket.close();
		ss.close();
		
	}
}	

class ClientService extends Thread {
	private Socket  socket;
		 
	ClientService(Socket socket) {
		this.socket = socket;
	}
		
	public void run() {
		try {
			while(true) {
				byte[] buf = new byte[1024];
				InputStream in = socket.getInputStream();
				
				int byteReadCount = in.read(buf);
					
				if (byteReadCount > 0) {
					String in_msg = new String(buf, 0,  byteReadCount,"UTF-8");
					System.out.println("Srv> ���� �޽���: "+in_msg);

					int result=0;
//					try {
//						ResultSet rs = DBJob.SQLInterpret(in_msg);
//						//������� ó��
//						while (rs.next()) {
//							// ��� �࿡ ���� ó��
//							System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column �̸��� ���� ���.
//							result++;
//						}
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
					// Send date and result of DBJob to client
					OutputStream out = socket.getOutputStream();
					BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(out));
					
					Date curr_now = new Date();
					String out_msg = new String("Srv> ���� ��¥�� "+curr_now.toString()+"Result of DBJob() :"+result);
				
					//writer.write(curr_now+"\r\n");
					writer.write(out_msg);
					writer.flush();
					//System.out.println("���� �ð�(����)"+curr_now.toString());
					System.out.println("Srv> ���� �޽���: "+out_msg);
				}
			}
		} catch (IOException e) {
			e.printStackTrace(); // System.out.println(e);
		}
	}


}




