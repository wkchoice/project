package db;

import java.sql.*;

public class DeleteEx1 {
	public static void main(String[] args) throws SQLException {
		// DB에 연결
		Connection con = DBUtil.getConnection(); // url, username, passwd
		Statement stmt = con.createStatement();
		
		String sql = "DELETE FROM employees WHERE employee_id = 110";
		int affectedRow = stmt.executeUpdate(sql); // INSERT,DELETE나 DDL을 실행할때, 성공여부나 성공한 개수를 리턴.
		System.out.println(affectedRow + "건의 데이터가 삭제되었습니다.");
		
		DBUtil.Close(stmt);
		DBUtil.Close();

	}
}
