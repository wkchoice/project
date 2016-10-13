package db;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.Formatter;

public class GetEmp {

	public static void main(String[] args) 	{   
		DecimalFormat df = new DecimalFormat("#00.00#");
		double d = 3.4;
		String dStr = df.format(d);
		System.out.println(dStr);
		
        Formatter formatter = new Formatter();
        formatter.format("%.3f", 123.45679);
        String str = formatter.toString();
        
        System.out.println(str); //123.457
        
		
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";         
		String DB_USER = "hr";         
		String DB_PASSWORD = "1234";         
		Connection conn = null;         
		Statement stmt = null;         
		ResultSet rs = null;         
		String query = "SELECT * FROM emp";         
		try {             
			// 드라이버를 로딩한다.             
			Class.forName("oracle.jdbc.driver.OracleDriver");         
		} catch (ClassNotFoundException e )	{ e.printStackTrace();}
		
		try {             // 데이터베이스의 연결을 설정한다.             
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);             
			// Statement를 가져온다.             
			stmt = conn.createStatement();             
			// SQL문을 실행한다.             
			rs = stmt.executeQuery(query);             
			while (rs.next()) {                 
				String empno = rs.getString(1);                 
				String ename = rs.getString(2);                 
				String job = rs.getString(3);                 
				String mgr = rs.getString(4);                 
				String hiredate = rs.getString(5);                 
				String sal = rs.getString(6);                 
				String comm = rs.getString(7);                 
				String depno = rs.getString(8);                 

				// 결과를 출력한다.                 
				System.out.println(empno + " : " + ename + " : " + job + " : " + 
						mgr+ " : " + hiredate + " : " + sal + " : " + comm + " : "                 
						+ depno);             
			}         
		} catch ( Exception e ) {             e.printStackTrace();         } 
		finally {             
			try {                 
				// ResultSet를 닫는다.                 
				rs.close();                 
				// Statement를 닫는다.                 
				stmt.close();                 
				// Connection를 닫는다.                 
				conn.close();            
			} 
			catch ( SQLException e ) {}         
		}     
	} // main()의 끝 } // 클래스의 끝
}
