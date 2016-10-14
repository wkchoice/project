package networkdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil0 {
	final static String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	final static String id  = "hr";
	final static String password = "1234";

	private static Connection con;

	static {
		// 오라클 JDBC 드라이버 class를 로딩(동적). 일반적으로 Class.forName메소드를 널리 사용
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			if (con != null && con.isClosed() == false) {
				return con;
			}
			// DB연결이 되지 않는 경우
			return (con = DriverManager.getConnection(url, id, password));
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