package ws2;

class TcpServer {
	port = 50500; 
	ss = new ServerSocket(port);
	while ((s = ss.accept()) != null) {
		Thread t = new Thread(new TcpServerThread(s));
		t.setDaemon(true);
		t.start();
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
			inMsg = buffRead.readLine();
			outMsg = DBJob.DBQuery(inMsg);
			printWrite = new PrintWriter(s.getOutputStream(),true);// To cli
			printWrite.println(outMsg);
		}
	}
}
class TcpClient {
	public static void main(String[] args) {
		port = 50500;
		s = new Socket("127.0.0.1", port);
		buffRead = new BufferedReader(new InputStreamReader(System.in)); // From man and To srv
		printWrite = new PrintWriter(s.getOutputStream());
		buffServ = new BufferedReader(new InputStreamReader(s.getInputStream())); // From srv
		while (true) {
			outMsg = buffRead.readLine();
			printWrite.println(outMsg);	printWrite.flush();
			inMsg = buffServ.readLine();
		}
	}
}
class DBUtil { 
	url, id, password;
	private static Connection con; 
	static { Class.forName("oracle.jdbc.dirver.OracleDrive"); }
	public static Connection getConnection() {
		return con = DriverManager.getConnection(url,id,password);
	}
	public static void Close(stmt, rs) {rs/stmt/con.close();}
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