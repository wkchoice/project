package networkdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import oracle.net.aso.s;

public class TcpClient0 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		final int port = 50005;
		Socket s = null;
		BufferedReader buffRead = null; // From Man
		BufferedReader buffServ = null; // From Server
		PrintWriter printWrite = null; // To Server

		try {
			s = new Socket("127.0.0.1", port);	// 1. Socket객체 생성
			buffRead = new BufferedReader(new InputStreamReader(System.in));

			// 2. I/O 작업 및 Stream 조회
			printWrite = new PrintWriter(s.getOutputStream()); // To Server
			buffServ = new BufferedReader(new InputStreamReader(s.getInputStream())); // From Server

			while (true) {
				System.out.println("Input message : ");
				String outMsg = buffRead.readLine();
				if (outMsg == null) {
					System.out.println("Good bye !!"); System.out.println("Disconnected with Server");
					break;
				}
				printWrite.println(outMsg); // Tx to Server
				printWrite.flush();

				String inMsg = buffServ.readLine(); // Rx from Server
				System.out.println("cli> Rx : "+inMsg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (buffRead != null) {
				try {
					buffRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (buffServ != null) buffServ.close();
			if (printWrite != null) printWrite.close();
			if (s != null) s.close();
		}
	}
}
