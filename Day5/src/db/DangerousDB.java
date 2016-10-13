package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DangerousDB {
	public static void main(String[] args) throws Exception {

		// DB에 연결
		Connection con = DBUtil.getConnection(); // url, username, passwd
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("조회할 사원: "); 
		String keyword = scanner.nextLine();
		
		// SQL 전송
		String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql); // SELECT를 실행할때, 결과는 ResultSet으로 리턴
		
		//결과집합 처리
		while (rs.next()) {
			//결과 행에 대한 처리
			System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column 이름을 직접 사용.
		}
		
		DBUtil.Close(stmt, rs);
		DBUtil.Close();
	}
}
