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
		// ����Ŭ JDBC ����̹� class�� �ε�(����). �Ϲ������� Class.forName�޼ҵ带 �θ� ���
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
			// DB������ ���� �ʴ� ���
			return (con = DriverManager.getConnection(url, id, password));
		} catch (SQLException e) {
			System.out.println("[����] DB���ῡ ���� �Ͽ����ϴ�.");
		}
		return con;
	}

	public static void Close() {
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				System.out.println("[����] DB������ ������ ������ �߻��Ͽ����ϴ�.");
			}
		}
	}

	public static void Close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("[����] DB������ ������ ������ �߻��Ͽ����ϴ�.");
			}
		}
	}

	public static void Close(Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("[����] DB������ ������ ������ �߻��Ͽ����ϴ�.");
			}
		}

		Close(stmt);
	}
}