package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	public static Connection getConnection(String url, String id, String pw) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB���� ����");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB���� ����");
		}
		return conn;
	}
}
