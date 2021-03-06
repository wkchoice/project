package ws1;

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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

	public class TstEx1 {  // TcpServer1
		public final static int PORT = 40005;
		
		public static void main(String[] args) throws IOException {
			// 1. ServerSocket 생성.port. 40005
			ServerSocket ss = new ServerSocket();
			ss.bind(new InetSocketAddress(PORT));
			
			System.out.println("Srv> 서버 시작 합니다."+(new Date()));
			Date curr_now;
			try {
				while (true) {
					Socket socket = ss.accept(); //클라이언트 접속 요청이 있을 때까지 block됨.
					
					// Send date to client
					// 2. I/O 작업
					// 2-1. OutputStream 받아오기 및 buffering
					OutputStream out = socket.getOutputStream();
					BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(out));
					
					// 2-2. 작업
					curr_now = new Date();
					writer.write(curr_now+"\r\n");
					writer.flush();
					//System.out.println("현재 시각(서버)"+curr_now.toString());
					
					System.out.println("Srv> 클라이언트 접속: "+socket.getRemoteSocketAddress()+", 현재 시각 - "+curr_now);
					// 3. 클라이언드 접속.
					ClientService service = new ClientService(socket);
					service.setDaemon(true);
					service.start(); //  Start and run Thread
				}
			} catch (Exception e) { }
			
//			int buf_size = 1024;
//			byte[] buf = new byte[ buf_size ];
//			
//			//	outputstream : prog로 들어오는 stream(=data). server기준
//			//	inputstream : prog로부터 나가는 stream(=data). server기준
//			InputStream in = socket.getInputStream(); 
//			int byteReadCount = in.read(buf);
//			
//			String msg = new String(buf, 0, byteReadCount, "UTF-8");
//			System.out.println("전송메시지 :"+msg);
//			
//			socket.close();
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
						System.out.println("Srv> 수신 메시지: "+in_msg);

						int result=0;
//						try {
//							ResultSet rs = DBJob.SQLInterpret(in_msg);
//							//결과집합 처리
//							while (rs.next()) {
//								// 결과 행에 대한 처리
//								System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column 이름을 직접 사용.
//								result++;
//							}
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						
						// Send date and result of DBJob to client
						OutputStream out = socket.getOutputStream();
						BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(out));
						
						Date curr_now = new Date();
						String out_msg = new String("Srv> 지금 날짜는 "+curr_now.toString()+"Result of DBJob() :"+result);
					
						//writer.write(curr_now+"\r\n");
						writer.write(out_msg);
						writer.flush();
						//System.out.println("현재 시각(서버)"+curr_now.toString());
						System.out.println("Srv> 전송 메시지: "+out_msg);
					}
				}
			} catch (IOException e) {
				e.printStackTrace(); // System.out.println(e);
			}
		}


	}
