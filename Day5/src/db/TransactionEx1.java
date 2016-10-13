package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionEx1 {
	public static void main(String[] args) throws SQLException {
		// DB�� ����
		Connection con = DBUtil.getConnection(); // url, username, passwd
		con.setAutoCommit(false); // Transactionó�� ����
		Statement stmt = con.createStatement();
		String keyword = "90";
		
		try {
			// Transactionó�� �����ʴ� ��� ����
			// -----------------------------------------------------------------------
			String sql1 = "UPDATE employees SET salary = salary * 1.1 WHERE department_id = 90";
			int affectedRow = stmt.executeUpdate(sql1); // INSERT,DELETE, UPDATE�� DDL�� �����Ҷ�, �������γ� ������ ������ ����.
			System.out.println(affectedRow + "���� �����Ͱ� ����Ǿ����ϴ�.");
			
			//PreparedStatement ����.(��õ ���)
			String sql = "SELECT * FROM employees WHERE department_id = ?";
			PreparedStatement stmt_sel = con.prepareStatement(sql);
			stmt_sel.setString(1, keyword);
			ResultSet rs = stmt_sel.executeQuery(); // SELECT�� �����Ҷ�, ����� ResultSet���� ����
			System.out.println("sql : "+sql);
			
			//������� ó��
			while (rs.next()) {
				//��� �࿡ ���� ó��
				System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")+","+rs.getInt("salary")); // column �̸��� ���� ���.
			}
			
			// -----------------------------------------------------------------------
			String sql2 = "UPDATE employees SET salary = salary * 0.9 WHERE department_id = 60";
			affectedRow = stmt.executeUpdate(sql2);// INSERT, DELETE, UPDATE�� DDL�� �����Ҷ�, �������γ� ������ ������ ����.
			System.out.println(affectedRow + "�� �����Ͱ� ����Ǿ����ϴ�.");
			// -----------------------------------------------------------------------
			
			String sql_tst = "SELECT * FROM employees WHERE first_name = ?";
			String first_name = "Lex";
			stmt_sel = con.prepareStatement(sql_tst);
			stmt_sel.setString(1, "Neena");
			rs = stmt_sel.executeQuery();
			System.out.println("sql : "+sql_tst);
			
			while (rs.next()) {
				System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")+","+rs.getInt("salary")); // column �̸��� ���� ���.
			}
			
			DBUtil.Close(stmt_sel, rs);
			con.commit(); // ���� ������ DB�� ������ �ݿ���. Transactionó������.
		} catch (Exception e) {
			con.rollback(); // �������µ� DB�� ����
		}
		
		DBUtil.Close(stmt);
		DBUtil.Close();

	}
}
