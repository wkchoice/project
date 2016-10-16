package network;

import java.sql.*;
import db.*;

public class DBJob {
	
	public static ResultSet SQLInterpret(String sql) throws Exception {
			// DB�� ����
			Connection con = DBUtil.getConnection(); // url, username, passwd
			con.setAutoCommit(false); // Transactionó�� ����
			
			// SQL ����
			// 1. Statement���� - server���� 
			//String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
			Statement stmt = con.createStatement();
			
			int affectedRow = 0;
			ResultSet rs = null;
		
			if (sql.contains("UPDATE") || sql.contains("INSERT") || sql.contains("DELETE") ) 
				affectedRow = stmt.executeUpdate(sql); // INSERT,DELETE, UPDATE�� DDL�� ����
			else
				rs = stmt.executeQuery(sql); // SELECT

//			//2. PreparedStatement ����.(��õ ���) - client����
//			String sql = "SELECT * FROM employees WHERE first_name = ?";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setString(1, keyword);
//			ResultSet rs = stmt.executeQuery(); // SELECT�� �����Ҷ�, ����� ResultSet���� ����
			
			//3. update
			// String sql1 = "UPDATE employees SET salary = salary * 1.1 WHERE department_id = 90";
			// int affectedRow = stmt.executeUpdate(sql1); // INSERT,DELETE, UPDATE�� DDL�� �����Ҷ�, �������γ� ������ ������ ����.
			// System.out.println(affectedRow + "���� �����Ͱ� ����Ǿ����ϴ�.");
			
			System.out.println("Srv> sql : "+sql);

			try {
				//������� ó��
				if (rs != null) {
					while (rs.next()) {
						// ��� �࿡ ���� ó��
						// System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column �̸��� ���� ���.
					}
				}
				con.commit(); // ���� ������ DB�� ������ �ݿ���. Transactionó������.
			} catch (Exception e) {
				con.rollback(); // �������µ� DB�� ����
				return null;
			}
			
			DBUtil.Close(stmt, rs);
			DBUtil.Close();
			
			return rs;
	}
}
