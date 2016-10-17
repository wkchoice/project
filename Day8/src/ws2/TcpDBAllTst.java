package ws2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TcpDBAllTst {
}

class TcpServer {
	public final static int port = 50500;
	public static void main(String[] args) {
		ServerSocket ss = null; Socket s = null;
		ss = new ServerSocket(port);
		while ((s = ss.accept()) != null) {
			Thread t = new Thread(new TcpServerThread(s));
			t.setDaemon(true);
			t.start();
		}
	}
}
class TcpServerThread implements Runnable {
	private Socket s = null;
	public TcpServerThread(Socket s) {this.s = s;}
	@Override
	public void run() {
		BufferedReader buffRead = null;	PrintWriter printWrite = null;
		while (true) {
			buffRead = new BufferedReader(new InputStreamReader(s.getInputStream()));// From cli
			String inMsg = buffRead.readLine();
			String outMsg = DBJob.DBQuery(inMsg);
			printWrite = new PrintWriter(s.getOutputStream(),true);// To cli
			printWrite.println(outMsg);
		}
	}
}
class TcpClient {
	public static void main(String[] args) {
		final int port = 50500;
		Socket s = null;  PrintWriter printWrite = null;
		BufferedReader buffRead, buffServ = null;

		s = new Socket("127.0.0.1", port);
		buffRead = new BufferedReader(new InputStreamReader(System.in)); // From man and To srv
		printWrite = new PrintWriter(s.getOutputStream());
		buffServ = new BufferedReader(new InputStreamReader(s.getInputStream())); // From srv
		while (true) {
			String outMsg = buffRead.readLine();
			printWrite.println(outMsg);	printWrite.flush();
			String inMsg = buffServ.readLine();
		}
	}
}
class DBUtil { 
	final static String url, id, password;
	private static Connection con; 
	static { Class.forName("oracle.jdbc.dirver.OracleDrive"); }
	public static Connection getConnection() {
		return con = DriverManager.getConnection(url,id,password);
	}
	public static void Close(Statement stmt, ResultSet rs) {rs.close(); stmt.close(); con.close();}
}
class DBJob {
	public static String DBQuery(String sql) {
		Connection con = DBUtil.getConnection(); // 1.
		Statement stmt = con.createStatement(); // 2.
		ResultSet rs = stmt.executeQuery(sql); // 3. 
		while (rs.next()) {	String rsMsg = rs.getString(1); } // 4.
		DBUtil.Close(stmt, rs); // 5.
		return rsMsg;
	}
}
