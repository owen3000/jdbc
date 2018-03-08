package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1. 드라이버 로딩
			Class.forName( "com.mysql.jdbc.Driver" );
			
			//2. 연결하기
			String url="jdbc:mysql://localhost/dev";
			conn = DriverManager.getConnection(url, "dev", "dev");
			
			//3. Statement 객체 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = 
				"select name," + 
				"       owner," + 
				"       species," + 
				"       date_format(birth, '%Y-%m-%d')" + 
				"  from pet";
			rs = stmt.executeQuery(sql);
			
			//4. 결과 처리
			while( rs.next() ) {
				String name = rs.getString( 1 );
				String owner = rs.getString( 2 );
				String species = rs.getString( 3 );
				String birth = rs.getString( 4 );
				
				System.out.println( name + ":" + owner + ":" + species + ":" + birth );
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e ) {
			System.out.println( "에러:" + e );
		} finally {
			// 자원정리(Clean-Up)
			try {
				if( rs != null ) {
					rs.close();
				}				
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
