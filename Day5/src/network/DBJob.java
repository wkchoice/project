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
			ResultSet rs = stmt.executeQuery(sql);

//			//2. PreparedStatement ����.(��õ ���) - client����
//			String sql = "SELECT * FROM employees WHERE first_name = ?";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setString(1, keyword);
//			ResultSet rs = stmt.executeQuery(); // SELECT�� �����Ҷ�, ����� ResultSet���� ����
			
			System.out.println("Srv> sql : "+sql);
			
			try {
				//������� ó��
				while (rs.next()) {
					// ��� �࿡ ���� ó��
					// System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column �̸��� ���� ���.
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
