package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

public class NoticeDao {

	// member
	private String url;
	private String user;
	private String password;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 싱글톤 패턴
	private NoticeDao() {
		this.url = "jdbc:mysql://localhost:3306/my_rental_car";
		this.user = "root";
		this.password = "root";
				
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	private static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() {
		return instance;
	}
	
	//CRUD
	
	// 1. Create
	public void createNotice(NoticeDto board) {
		String sql = "INSERT INTO notice VALUES(?,?,?,?,?,?,?)";
		int no = noGenerator();	// 마지막 no + 1;
		try {
			// no/title/content/user/password/regDate/modDate/viewCnt
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, no);
			this.pstmt.setString(2, board.getTitle());
			this.pstmt.setString(3, board.getContent());
			this.pstmt.setString(4, board.getUser());
			Timestamp now = new Timestamp(System.currentTimeMillis());
			this.pstmt.setTimestamp(5, now);
			this.pstmt.setTimestamp(6, now);
			this.pstmt.setInt(7, 0);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
	}
	
	public int noGenerator() {
		String sql = "SELECT MAX(no) FROM notice";
		int no = 0;
		
		try {
			this.conn = DBManager.getConnection(url, user, password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()){
				no = rs.getInt(1)+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
		
		return no;
	}
	// 2. Read
	
	// 2-1 Read All
	public ArrayList<NoticeDto> getNoticeAll(){
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		String sql = "SELECT * FROM notice ORDER BY `no` DESC";
		
		try {
			this.conn = DBManager.getConnection(url, user, password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			while(this.rs.next()) {
				// no/title/content/user/password/regDate/modDate/viewCnt
				int no = this.rs.getInt(1);
				String title = this.rs.getString(2);
				String content = this.rs.getString(3);
				String user = this.rs.getString(4);
				Timestamp regDate = this.rs.getTimestamp(5);
				Timestamp modDate = this.rs.getTimestamp(6);
				int viewCnt = this.rs.getInt(7);
				
				NoticeDto board = new NoticeDto(no,title, content,user, regDate, modDate, viewCnt);
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 2-2 Read One
	public NoticeDto getNoticeByNo(int no) {
		NoticeDto notice = null;
		String sql = "SELECT * FROM notice WHERE `no`=?";
		
		try {
			this.conn = DBManager.getConnection(url, user, password);
			this.pstmt = this.conn.prepareCall(sql);
			this.pstmt.setInt(1, no);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String title = this.rs.getString(2);
				String content = this.rs.getString(3);
				String user = this.rs.getString(4);
				Timestamp regDate = this.rs.getTimestamp(5);
				Timestamp modDate = this.rs.getTimestamp(6);
				int viewCnt = this.rs.getInt(7);
				
				notice = new NoticeDto(no,title, content,user, regDate, modDate, viewCnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
		
		return notice;
	}
	// 3. Update
	public void updateNotice(NoticeDto board) {
		String sql="UPDATE notice SET title=?, content=?, modDate=? WHERE no=?";
		int no = board.getNo();
		String title = board.getTitle();
		String content = board.getContent();
//		String password = board.getPassword();
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1,title);
			this.pstmt.setString(2, content);
			Timestamp now = new Timestamp(System.currentTimeMillis());
			this.pstmt.setTimestamp(3, now);
			this.pstmt.setInt(4, no);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
	}
	
	public void countView(int no) {
		String sql = "UPDATE notice SET viewCnt=? WHERE `no`=?";
		NoticeDto board = getNoticeByNo(no);
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, board.getViewCnt()+1);
			this.pstmt.setInt(2, no);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
	}
	// 4. Delete
	public void deleteNotice(int no) {
		String sql="DELETE FROM notice WHERE no=?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, no);
			this.pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch (SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
	}
}
