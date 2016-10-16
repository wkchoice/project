import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TcpServer { // 1.
	public final static int port = 50005;
	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;	Socket s = null; 
		try {
			ss = new ServerSocket(port);
			while ((s = ss.accept()) != null) {
				Thread t = new Thread(new TcpServerThread(s));
				t.setDaemon(true);
				t.start();
			}
		} catch (Exception e) {	}
	}
}

public class TcpServerThread implements Runnable { // 2.
	private Socket s;
	public TcpServerThread(Socket s) { // constructor
		this.s = s;
	}
	@Override
	public void run() {
		BufferedReader buffRead = null;
		PrintWriter printWrite = null;
		try {
			while(true) {
				buffRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String inMsg = buffRead.readLine();
				if (inMsg == null) break;
				String outMsg = DBJob.SQLQuery(inMsg);
				printWrite = new PrintWriter(s.getOutputStream(), true);
				printWrite.println(outMsg);
			}
			printWrite.flush();
		} catch (Exception e) {	}
	}
}

public class TcpClient { // 3.
	public static void main(String[] args) throws UnknownHostException, IOException {
		final int port = 50005;
		Socket s = null;
		BufferedReader buffRead = null; // From Man
		BufferedReader buffServ = null; // From Server
		PrintWriter printWrite = null; // To Server
		try {
			s = new Socket("127.0.0.1", port);	// 1. Socket객체 생성
			buffRead = new BufferedReader(new InputStreamReader(System.in));
			printWrite = new PrintWriter(s.getOutputStream()); // To Server
			buffServ = new BufferedReader(new InputStreamReader(s.getInputStream())); // From Server

			while (true) {
				System.out.println("Input message : ");
				String outMsg = buffRead.readLine(); // wait from MAN
				if (outMsg == null) {break;	}
				printWrite.println(outMsg); // Tx to Server
				printWrite.flush();
				String inMsg = buffServ.readLine(); // Rx from Server
			}
		} catch (Exception e) {	}
	}
}

public class DBUtil { // 4
	final static String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	final static String id  = "hr";
	final static String password = "1234";

	private static Connection con;
	static {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public static Connection getConnection() {
		if (con != null && con.isClosed() == false) {	}
		else con = DriverManager.getConnection(url, id, password);
		return con;
	}

	public static void Close() {
		con.close();
	}
	public static void Close(Statement stmt) {
		stmt.close();
	}
	public static void Close(Statement stmt, ResultSet rs) {
		rs.close();	Close(stmt);
	}
}

public class DBJob { // 5.
	public static String SQLQuery(String sql) throws Exception {
		// DB에 연결
		String rsMsg;
		Connection con = DBUtil.getConnection(); // url, username, passwd
		con.setAutoCommit(false); // Transaction처리 시작
		// SQL 전송
		Statement stmt = con.createStatement();
		int affectedRow = 0; ResultSet rs = null;
		if (sql.contains("UPDATE")) affectedRow = stmt.executeUpdate(sql);
		else rs = stmt.executeQuery(sql); // SELECT
		try {
			while (rs != null && rs.next()) {
				rsMsg += rs.getString("employee_id");
			}
			con.commit(); 
		} catch (Exception e) {	}
		DBUtil.Close(stmt, rs);
		DBUtil.Close();
		return rsMsg;
	}
}