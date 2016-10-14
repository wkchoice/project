package networkdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBJob0 {
		public static String SQLInterpret(String sql) throws Exception {
				// DB에 연결
			    String sql_rs = "";
				Connection con = DBUtil0.getConnection(); // url, username, passwd
				con.setAutoCommit(false); // Transaction처리 시작
				
				// SQL 전송
				// 1. Statement사용시 - server에서 
				//String sql = "SELECT * FROM employees WHERE first_name = '" + keyword +"'"; // Dangerous String or Usage
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

//				//2. PreparedStatement 사용시.(추천 방법) - client에서
//				String sql = "SELECT * FROM employees WHERE first_name = ?";
//				PreparedStatement stmt = con.prepareStatement(sql);
//				stmt.setString(1, keyword);
//				ResultSet rs = stmt.executeQuery(); // SELECT를 실행할때, 결과는 ResultSet으로 리턴
				
//				System.out.println("srv> Rx sql : "+sql);
								
				try {
					//결과집합 처리
					while (rs.next()) {
						// 결과 행에 대한 처리
						// rs.getString(1) // First coulumn of result of running Queqry in oracle is getted.
						// System.out.println(rs.getRow()+" : "+rs.getString("employee_id")+", "+rs.getString("first_name")+", "+rs.getString("last_name")); // column 이름을 직접 사용.
						//sql_rs += rs.getString("employee_id")+", "+rs.getString("first_name"+", "+rs.getString("last_name")+"\r\n");
						sql_rs += rs.getString("employee_id");
					}
					con.commit(); // 변경 내용을 DB에 완전히 반영함. Transaction처리종료.
				} catch (Exception e) {
					con.rollback(); // 원래상태도 DB를 복원
				}
				
				DBUtil0.Close(stmt, rs);
				DBUtil0.Close();
				
				return sql_rs;
		}
	}
