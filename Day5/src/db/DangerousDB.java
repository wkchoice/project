package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DangerousDB {
	public static void main(String[] args) throws Exception {

		// DB�� ����
		Connection con = DBUtil.getConnection(); // url, username, passwd
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("��ȸ�� ���: "); 
		String keyword = scanner.nextLine();
		
		// SQL ����
		String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql); // SELECT�� �����Ҷ�, ����� ResultSet���� ����
		
		//������� ó��
		while (rs.next()) {
			//��� �࿡ ���� ó��
			System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column �̸��� ���� ���.
		}
		
		DBUtil.Close(stmt, rs);
		DBUtil.Close();
	}
}
