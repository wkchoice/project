package networkdb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class TcpServerThread0 implements Runnable {
	private Socket s;

	public TcpServerThread0(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		BufferedReader buffRead = null;
		BufferedWriter buffWrite = null;
		PrintWriter printWrite = null;
		
		try {
			while(true) {
				buffRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				String inMsg = buffRead.readLine();
				if (inMsg == null) break;
				
				System.out.println("srv> Rx : "+inMsg);

//				Date curr_now = new Date();
				// case.1 String
				// String outMsg = new String("지금 날짜는 "+curr_now.toString());
				String outMsg = DBJob0.SQLInterpret(inMsg);

				// Tx-usage-1 Tx date and result of DBJob to client
				printWrite = new PrintWriter(s.getOutputStream(), true);
				printWrite.println(inMsg+" + "+outMsg);
				printWrite.flush();
				
				// Tx-usage-2 Tx date and result of DBJob to client
//				buffWrite = new BufferedWriter( new OutputStreamWriter(s.getOutputStream()));
//				//buffWrite.write(curr_now+"\r\n");
//				buffWrite.write(inMsg+" + "+outMsg+"\r\n");
//				buffWrite.flush();
				
				System.out.println("srv> Tx : "+inMsg+" + "+outMsg+"="+outMsg.length());
				
				// ConsoleToMemo.java( Rx and Tx messages are saved in File  )
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
			if (buffWrite != null) {
				try {
					buffWrite.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
			if (printWrite != null)
				printWrite.close();
			
			if (s != null)
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
