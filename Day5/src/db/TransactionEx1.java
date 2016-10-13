package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionEx1 {
	public static void main(String[] args) throws SQLException {
		// DB에 연결
		Connection con = DBUtil.getConnection(); // url, username, passwd
		con.setAutoCommit(false); // Transaction처리 시작
		Statement stmt = con.createStatement();
		String keyword = "90";
		
		try {
			// Transaction처리 되지않는 경우 예제
			// -----------------------------------------------------------------------
			String sql1 = "UPDATE employees SET salary = salary * 1.1 WHERE department_id = 90";
			int affectedRow = stmt.executeUpdate(sql1); // INSERT,DELETE, UPDATE나 DDL을 실행할때, 성공여부나 성공한 개수를 리턴.
			System.out.println(affectedRow + "건의 데이터가 변경되었습니다.");
			
			//PreparedStatement 사용시.(추천 방법)
			String sql = "SELECT * FROM employees WHERE department_id = ?";
			PreparedStatement stmt_sel = con.prepareStatement(sql);
			stmt_sel.setString(1, keyword);
			ResultSet rs = stmt_sel.executeQuery(); // SELECT를 실행할때, 결과는 ResultSet으로 리턴
			System.out.println("sql : "+sql);
			
			//결과집합 처리
			while (rs.next()) {
				//결과 행에 대한 처리
				System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")+","+rs.getInt("salary")); // column 이름을 직접 사용.
			}
			
			// -----------------------------------------------------------------------
			String sql2 = "UPDATE employees SET salary = salary * 0.9 WHERE department_id = 60";
			affectedRow = stmt.executeUpdate(sql2);// INSERT, DELETE, UPDATE나 DDL을 실행할때, 성공여부나 성공한 개수를 리턴.
			System.out.println(affectedRow + "건 데이터가 변경되었습니다.");
			// -----------------------------------------------------------------------
			
			String sql_tst = "SELECT * FROM employees WHERE first_name = ?";
			String first_name = "Lex";
			stmt_sel = con.prepareStatement(sql_tst);
			stmt_sel.setString(1, "Neena");
			rs = stmt_sel.executeQuery();
			System.out.println("sql : "+sql_tst);
			
			while (rs.next()) {
				System.out.println(rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")+","+rs.getInt("salary")); // column 이름을 직접 사용.
			}
			
			DBUtil.Close(stmt_sel, rs);
			con.commit(); // 변경 내용을 DB에 완전히 반영함. Transaction처리종료.
		} catch (Exception e) {
			con.rollback(); // 원래상태도 DB를 복원
		}
		
		DBUtil.Close(stmt);
		DBUtil.Close();

	}
}
