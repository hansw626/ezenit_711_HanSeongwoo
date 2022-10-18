package money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.MemberDao;
import member.MemberDto;
import util.DBManager;

public class MoneyDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url;
	private String user;
	private String password;
	
	private MoneyDao() {
		this.url = "jdbc:oracle:thin:@DESKTOP-8U20BN7:1521:xe";
		this.user = "c##system";
		this.password = "1234";
	}
	
	private static MoneyDao instance = new MoneyDao();
	
	public static MoneyDao getInstance() {
		return instance;
	}
	
	public ArrayList<String[]> getSalebyMember(){
		ArrayList<String[]> result = new ArrayList<>();
		MemberDao memberDao = MemberDao.getInstance();
		String sql = "SELECT custno, sum(price) AS total FROM money_tbl_02 GROUP BY custno ORDER BY total DESC";
		
		try {
			this.conn = DBManager.getConnection(url, user, password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				String[] data = new String[4];
				int custno = Integer.parseInt(this.rs.getString(1));
				MemberDto member = memberDao.getMember(custno);
				data[0] = custno + "";
				data[1] = member.getCustname();
				data[2] = member.getGrade();
				data[3] = this.rs.getString(2);
				
				result.add(data);
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
}
