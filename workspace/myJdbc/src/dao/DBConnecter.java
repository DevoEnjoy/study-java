package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	public static Connection getConnection() {
		Connection connection = null;
		
//		���ῡ �ʿ��� ����
		String userName = "hr";
		String password = "hr";
		String url = "jdbc:oracle:thin:@localhist:1521:XE";
		
//		����̹��� �޸𸮿� �Ҵ�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		������ �����Ͽ� ���� ��ü ��������
		
		
		return connection;
	}
	
	
	
}
