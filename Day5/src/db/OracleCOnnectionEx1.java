package db;

import java.sql.*;

public class OracleCOnnectionEx1 {
	public static void main(String[] args) throws Exception {
//		new AAA();
//		Class.forName("db.AAA");
		
		// 오라클 JDBC 드라이버를 로딩.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// DB에 연결
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
		Connection con = DriverManager.getConnection(url, "hr", "1234"); // url, username, passwd
		
		// SQL 전송
		String sql = "SELECT * FROM employees";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql); // stmt.executeQuery("SELECT * FROM employees");
		
		//결과집합 처리
		while (rs.next()) {
			//결과 행에 대한 처리
			String emp_id = rs.getString(1);
			String f_name = rs.getString(2);
			String l_name = rs.getString(3);
//			System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3));
//			System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column 이름을 직접 사용.
			System.out.println(emp_id+", "+f_name+", "+l_name); // column 이름을 직접 사용.
		}
		
		rs.close();
		stmt.close();
		con.close();
	}
}

//class AAA {
//	static {
//		System.out.println("초기화 작업이 수행되었습니다.");
//	}
//}

