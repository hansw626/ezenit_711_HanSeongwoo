package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;

import util.DBManager;

public class MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url;
	private String user;
	private String password;
	
	// Singleton pattern
	private MemberDao() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user = "c##system";
		this.password = "1234";
	}
	
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	public Timestamp getTimestamp(String date) {
		String[] data = date.split("-");
		int year = Integer.parseInt(data[0])-1900;
		int month = Integer.parseInt(data[1]);
		int day = Integer.parseInt(data[2]);
		
		Date info = new Date(year, month, day);
		Timestamp timestamp = new Timestamp(info.getTime());
		return timestamp;
	}
	
	public String getJoindate(Timestamp date) {
		String result = date + "";
		return result.substring(0,10);
	}
	
	// 1.CREATE
	public int getNewCustno() {
		int custno = 0;
		String sql = "SELECT MAX(custno) FROM member_tbl_02";
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				custno = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		return custno;
	}
	
	public boolean addMember(MemberDto member) {
		boolean add = true;
		
		String sql = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,?,?,?)";
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, member.getCustno());
			this.pstmt.setString(2, member.getCustname());
			this.pstmt.setString(3, member.getPhone());
			this.pstmt.setString(4, member.getAddress());
			this.pstmt.setTimestamp(5, member.getJoindate());
			this.pstmt.setString(6, member.getGrade());
			this.pstmt.setString(7, member.getCity());
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		return add;
	}
	
	// 2.READ
	public MemberDto getMember(int custno) {
		MemberDto result = null;
		String sql = "SELECT * FROM member_tbl_02 where custno=?";
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, custno);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String custname = this.rs.getString(2);
				String phone = this.rs.getString(3);
				String address = this.rs.getString(4);
				Timestamp joindate = this.rs.getTimestamp(5);
				String grade = this.rs.getString(6);
				String city = this.rs.getString(7);
				
				result = new MemberDto(custno, custname, phone,
						address, joindate, grade, city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		return result;
	}
	
	public ArrayList<MemberDto> getMemberAll(){
		ArrayList<MemberDto> result = new ArrayList<>();
		String sql = "SELECT * FROM member_tbl_02";
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				int custno = this.rs.getInt(1);
				String custname = this.rs.getString(2);
				String phone = this.rs.getString(3);
				String address = this.rs.getString(4);
				Timestamp joindate = this.rs.getTimestamp(5);
				String grade = this.rs.getString(6);
				String city = this.rs.getString(7);
				
				result.add(new MemberDto(custno, custname, phone,
						address, joindate, grade, city));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
		return result;
	}
	// 3.UPDATE
	public void updateMember(MemberDto member) {
		
		String sql = "UPDATE member_tbl_02 SET custname=?, phone=?, address=?, joindate=?, grade=?, city=? WHERE custno=?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, member.getCustname());
			this.pstmt.setString(2, member.getPhone());
			this.pstmt.setString(3, member.getAddress());
			this.pstmt.setTimestamp(4, member.getJoindate());
			this.pstmt.setString(5, member.getGrade());
			this.pstmt.setString(6, member.getCity());
			this.pstmt.setInt(7, member.getCustno());
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		
	}
	// 4.DELETE
}
