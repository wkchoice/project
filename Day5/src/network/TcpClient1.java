package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;
import db.*;

public class TcpClient1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// 1. Socket객체 생성
		Socket socket = new Socket("127.0.0.1", 40005);

//		String msg = "안녕하세요?";
//		byte[] bytes = msg.getBytes("UTF-8");
//		OutputStream out = socket.getOutputStream();
//		out.write(bytes);
//		out.flush();
		
		// Receive date from server
		// 2. I/O 작업 및 Stream 조회
		InputStream in = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String server_time = reader.readLine();
		
		System.out.println("Cli> 서버에서 보낸 시각: "+server_time);
		
		OutputStream out = socket.getOutputStream();
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				if (scanner.hasNext()) {
					String msg = scanner.nextLine();
					
					byte[] to_bytes = msg.getBytes("UTF-8");
					out.write(to_bytes);
					out.flush();
				}
				
				// 수신 메시지
				byte[] buf = new byte[1024];
				in = socket.getInputStream();
				
				int byteReadCount = in.read(buf);
					
				if (byteReadCount > 0) {
					String in_msg = new String(buf, 0,  byteReadCount,"UTF-8");
					System.out.println("Cli> 수신 메시지: "+in_msg);
						
//					// Send date to client
//					OutputStream out = socket.getOutputStream();
//					BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(out));
//					
//					Date curr_now = new Date();
//					String out_msg = new String("지금 날짜는 "+curr_now.toString());
//					//writer.write(curr_now+"\r\n");
//					writer.write(out_msg);
//					writer.flush();
//					//System.out.println("현재 시각(서버)"+curr_now.toString());
//					System.out.println("전송 메시지: "+out_msg);
						
				}
			}
//			scanner.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		socket.close();
	}
}
