package db;

import java.sql.*;

public class DeleteEx1 {
	public static void main(String[] args) throws SQLException {
		// DB�� ����
		Connection con = DBUtil.getConnection(); // url, username, passwd
		Statement stmt = con.createStatement();
		
		String sql = "DELETE FROM employees WHERE employee_id = 110";
		int affectedRow = stmt.executeUpdate(sql); // INSERT,DELETE�� DDL�� �����Ҷ�, �������γ� ������ ������ ����.
		System.out.println(affectedRow + "���� �����Ͱ� �����Ǿ����ϴ�.");
		
		DBUtil.Close(stmt);
		DBUtil.Close();

	}
}
