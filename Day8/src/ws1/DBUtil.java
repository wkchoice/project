package ws1;

import java.sql.*;

public class DBUtil {
	final static String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	final static String id = "hr";
	final static String password = "1234";
	
	private  static Connection con;
	
	static {
		// 오라클 JDBC 드라이버 class를 로딩(동적). 
		// 일반적으로 Class.forName메소드를 널리 사용 
		// 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("[오류] 오라클 드라이버를 찾을 수 없습니다.");
		}
	}
	
	public static Connection getConnection() {
		try {
			if (con != null && con.isClosed()) {
				return con;
			}
			
			// DB연결이 되지 않는 경우
			con = DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			System.out.println("[오류] DB연결에 실패 하였습니다.");
		}
		return con;
	}
	
	public static void Close() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				System.out.println("[오류] DB연결을 끊는중 오류가 발생하였습니다.");
			}
		}
	}
	
	public static void Close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("[오류] DB연결을 끊는중 오류가 발생하였습니다.");
			}
		}
	}
	
	public static void Close(Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("[오류] DB연결을 끊는중 오류가 발생하였습니다.");
			}
		}
		
		Close(stmt);
	}
}
