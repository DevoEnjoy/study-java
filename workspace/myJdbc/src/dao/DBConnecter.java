package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	public static Connection getConnection() {
		Connection connection = null;
		
//		연결에 필요한 정보
		String userName = "hr";
		String password = "hr";
		String url = "jdbc:oracle:thin:@localhist:1521:XE";
		
//		드라이버를 메모리에 할당
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		정보를 전달하여 연결 객체 가져오기
		
		
		return connection;
	}
	
	
	
}
