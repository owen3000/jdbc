package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//1. 드라이버 로딩
			//Class.forName( "com.cafe24.jdbc.MyDriver" );
			Class.forName( "com.mysql.jdbc.Driver" );
			
			//2. 연결하기
			//String url="jdbc:cafe24://localhost/dev";
			String url="jdbc:mysql://localhost/dev";
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println( "연결 성공" );
			
		} catch (ClassNotFoundException e) {
			System.out.println( "드라이버 로딩 실패:" + e );
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			try {
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
