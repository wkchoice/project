package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementEx1 {
	public static void main(String[] args) throws Exception {

		// DB�� ����
		Connection con = DBUtil.getConnection(); // url, username, passwd
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("��ȸ�� ���: "); 
		String keyword = scanner.nextLine();
		
		
		// SQL ����
		// 1. Statement����
//		String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
//		Statement stmt = con.createStatement(); // co.preparedStatement( sql )�� ����
//		ResultSet rs = stmt.executeQuery(sql);  // pstmt.executeQuery(  )�� ����

		//2. PreparedStatement ����.(��õ ���)
		String sql = "SELECT * FROM employees WHERE first_name = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery(); // SELECT�� �����Ҷ�, ����� ResultSet���� ����
		
		System.out.println("sql : "+sql);
		
		//������� ó��
		while (rs.next()) {
			//��� �࿡ ���� ó��
			System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column �̸��� ���� ���.
		}
		
		DBUtil.Close(pstmt, rs);
		DBUtil.Close();
	}
}
