package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

public class UserDao {
	
	// Member
	private String url;
	private String user;
	private String password;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Constructor
	private UserDao() {
		this.url = "jdbc:mysql://localhost:3306/my_retal_car";
		this.user = "root";
		this.password = "root";
		
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	
	// Single tone Pattern
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	// CRUD
	// 1. Create
	public void createUser(UserDto user) {
		String sql = "INSERT INTO user_tbl VALUES(?,?,?,?,?,?,?)";
		
		String id = user.getId();	// PK
		String pw = user.getPw();
		String name = user.getName();
		String license = user.getLicense();
		String phone = user.getPhone();
		String address = user.getAddress();
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setString(1, id);
			this.pstmt.setString(2, pw);
			this.pstmt.setString(3, name);
			this.pstmt.setString(4, license);
			this.pstmt.setString(5, phone);
			this.pstmt.setString(6, address);
			Timestamp now = new Timestamp(System.currentTimeMillis());
			this.pstmt.setTimestamp(7, now);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 2-1 Read All
	public ArrayList<UserDto> getUserList() {
		ArrayList<UserDto> userList = new ArrayList<>();
		String sql = "SELECT * FROM user_tbl";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs= pstmt.executeQuery();
			
			while(this.rs.next()) {
				String id = this.rs.getString(1);
				String pw = this.rs.getString(2);
				String name = this.rs.getString(3);
				String license = this.rs.getString(4);
				String phone = this.rs.getString(5);
				String address = this.rs.getString(6);
				Timestamp regDate = this.rs.getTimestamp(7);
				
				UserDto user = new UserDto(id, pw, name, license, phone, address, regDate);
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}
	
	// 2-2 Read One
	public UserDto getUserById(String id) {
		UserDto user = null;
		String sql = "SELECT * FROM user_tbl WHERE id=?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, id);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String pw = this.rs.getString(2);
				String name = this.rs.getString(3);
				String license = this.rs.getString(4);
				String phone = this.rs.getString(5);
				String address = this.rs.getString(6);
				Timestamp regDate = this.rs.getTimestamp(7);
				
				user = new UserDto(id, pw, name, license, phone, address, regDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user;
	}
	
	// 4. Delete
	public void deleteUser(String id) {
		String sql = "DELETE FROM user_tbl WHERE id=?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, id);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// Other
}
