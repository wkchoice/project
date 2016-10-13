package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementEx1 {
	public static void main(String[] args) throws Exception {

		// DB에 연결
		Connection con = DBUtil.getConnection(); // url, username, passwd
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("조회할 사원: "); 
		String keyword = scanner.nextLine();
		
		
		// SQL 전송
		// 1. Statement사용시
//		String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
//		Statement stmt = con.createStatement(); // co.preparedStatement( sql )와 차이
//		ResultSet rs = stmt.executeQuery(sql);  // pstmt.executeQuery(  )와 차이

		//2. PreparedStatement 사용시.(추천 방법)
		String sql = "SELECT * FROM employees WHERE first_name = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery(); // SELECT를 실행할때, 결과는 ResultSet으로 리턴
		
		System.out.println("sql : "+sql);
		
		//결과집합 처리
		while (rs.next()) {
			//결과 행에 대한 처리
			System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column 이름을 직접 사용.
		}
		
		DBUtil.Close(pstmt, rs);
		DBUtil.Close();
	}
}
