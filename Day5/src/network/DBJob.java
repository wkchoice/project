package network;

import java.sql.*;
import db.*;

public class DBJob {
	
	public static ResultSet SQLInterpret(String sql) throws Exception {
			// DB에 연결
			Connection con = DBUtil.getConnection(); // url, username, passwd
			con.setAutoCommit(false); // Transaction처리 시작
			
			// SQL 전송
			// 1. Statement사용시 - server에서 
			//String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
			Statement stmt = con.createStatement();
			
			int affectedRow = 0;
			ResultSet rs = null;
		
			if (sql.contains("UPDATE") || sql.contains("INSERT") || sql.contains("DELETE") ) 
				affectedRow = stmt.executeUpdate(sql); // INSERT,DELETE, UPDATE나 DDL을 실행
			else
				rs = stmt.executeQuery(sql); // SELECT

//			//2. PreparedStatement 사용시.(추천 방법) - client에서
//			String sql = "SELECT * FROM employees WHERE first_name = ?";
//			PreparedStatement stmt = con.prepareStatement(sql);
//			stmt.setString(1, keyword);
//			ResultSet rs = stmt.executeQuery(); // SELECT를 실행할때, 결과는 ResultSet으로 리턴
			
			//3. update
			// String sql1 = "UPDATE employees SET salary = salary * 1.1 WHERE department_id = 90";
			// int affectedRow = stmt.executeUpdate(sql1); // INSERT,DELETE, UPDATE나 DDL을 실행할때, 성공여부나 성공한 개수를 리턴.
			// System.out.println(affectedRow + "건의 데이터가 변경되었습니다.");
			
			System.out.println("Srv> sql : "+sql);

			try {
				//결과집합 처리
				if (rs != null) {
					while (rs.next()) {
						// 결과 행에 대한 처리
						// System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column 이름을 직접 사용.
					}
				}
				con.commit(); // 변경 내용을 DB에 완전히 반영함. Transaction처리종료.
			} catch (Exception e) {
				con.rollback(); // 원래상태도 DB를 복원
				return null;
			}
			
			DBUtil.Close(stmt, rs);
			DBUtil.Close();
			
			return rs;
	}
}
