package networkdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBJob0 {
		public static String SQLInterpret(String sql) throws Exception {
				// DB�� ����
			    String sql_rs = "";
				Connection con = DBUtil0.getConnection(); // url, username, passwd
				con.setAutoCommit(false); // Transactionó�� ����
				
				// SQL ����
				// 1. Statement���� - server���� 
				//String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
				// String sql = "DELETE FROM employees WHERE employee_id = 110";
				// String sql1 = "UPDATE employees SET salary = salary * 1.1 WHERE department_id = 90";
				Statement stmt = con.createStatement();
				int affectedRow = 0; ResultSet rs = null;
			
				if (sql.contains("UPDATE") || sql.contains("INSERT") || sql.contains("DELETE") ) 
					affectedRow = stmt.executeUpdate(sql); // INSERT,DELETE, UPDATE�� DDL�� ����
				else
					rs = stmt.executeQuery(sql); // SELECT

//				//2. PreparedStatement ����.(��õ ���) - client����
//				String sql = "SELECT * FROM employees WHERE first_name = ?";
//				PreparedStatement stmt = con.prepareStatement(sql);
//				stmt.setString(1, keyword);
//				ResultSet rs = stmt.executeQuery(); // SELECT�� �����Ҷ�, ����� ResultSet���� ����
				
//				System.out.println("srv> Rx sql : "+sql);
								
				try {
					//������� ó��
					while (rs != null && rs.next()) {
						// ��� �࿡ ���� ó��
						// rs.getString(1) // First coulumn of result of running Queqry in oracle is getted.
						// System.out.println(rs.getRow()+" : "+rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column �̸��� ���� ���.
						//sql_rs += rs.getString("employee_id")+", "+rs.getString("first_name"+", "+rs.getString("last_name")+"\r\n");
						sql_rs += rs.getString("employee_id");
					}
					con.commit(); // ���� ������ DB�� ������ �ݿ���. Transactionó������.
				} catch (Exception e) {
					con.rollback(); // �������µ� DB�� ����
				}
				
				DBUtil0.Close(stmt, rs);
				DBUtil0.Close();
				
				return sql_rs;
		}
	}
