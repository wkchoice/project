package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleCOnnectionEx2 { // OracleCOnnectionEx1�� ���� �������ְ� ������ ����.
	public static void main(String[] args) throws Exception {

		// DB�� ����
		Connection con = DBUtil.getConnection(); // url, username, passwd
		
		// SQL ����
		String sql = "SELECT * FROM employees";
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
