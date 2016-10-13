package db;

import java.sql.*;

public class OracleCOnnectionEx1 {
	public static void main(String[] args) throws Exception {
//		new AAA();
//		Class.forName("db.AAA");
		
		// ����Ŭ JDBC ����̹��� �ε�.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// DB�� ����
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
		Connection con = DriverManager.getConnection(url, "hr", "1234"); // url, username, passwd
		
		// SQL ����
		String sql = "SELECT * FROM employees";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql); // stmt.executeQuery("SELECT * FROM employees");
		
		//������� ó��
		while (rs.next()) {
			//��� �࿡ ���� ó��
			String emp_id = rs.getString(1);
			String f_name = rs.getString(2);
			String l_name = rs.getString(3);
//			System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3));
//			System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column �̸��� ���� ���.
			System.out.println(emp_id+", "+f_name+", "+l_name); // column �̸��� ���� ���.
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}

//class AAA {
//	static {
//		System.out.println("�ʱ�ȭ �۾��� ����Ǿ����ϴ�.");
//	}
//}

