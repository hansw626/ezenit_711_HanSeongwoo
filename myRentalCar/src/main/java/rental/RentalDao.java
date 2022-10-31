package rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import car.CarDao;
import util.DBManager;

public class RentalDao {
	
	// Member
	private String url;
	private String user;
	private String password;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Constructor
	private RentalDao() {
		this.url = "jdbc:mysql://localhost:3306/my_rental_car";
		this.user = "root";
		this.password = "root";
		
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	
	// Single tone Pattern
	private static RentalDao instance = new RentalDao();
	
	public static RentalDao getInstance() {
		return instance;
	}
	
	// CRUD
	// 1. Create
	public void createRentalInfo(RentalVo rental) {
		String sql = "INSERT INTO rental_tbl VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		int no = getNo() + 1;
		String userId = rental.getUserId();
		String carCode = rental.getCarCode();
		Timestamp sDate = rental.getsDate();
		Timestamp eDate = rental.geteDate();
		String place = rental.getPlace();
		String reason = rental.getReason();
		int price = rental.getPrice();
		int cost = rental.getCost();
		int mileage = 0;
		System.out.printf("%d,%s,%s,%s,%s,%s,%s,%d,%d,%d\n\n",
				no, userId, carCode, sDate, eDate, place, reason, price, cost, mileage);
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, no);
			this.pstmt.setString(2, userId);
			this.pstmt.setString(3, carCode);
			this.pstmt.setTimestamp(4, sDate);
			this.pstmt.setTimestamp(5, eDate);
			this.pstmt.setString(6, place);
			this.pstmt.setString(7, reason);
			this.pstmt.setInt(8, price);
			this.pstmt.setInt(9, cost);
			this.pstmt.setInt(10, mileage);
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
	
	// 2. Read
	public ArrayList<RentalVo> getUserRentalInfoAll(String id){
		ArrayList<RentalVo> rentalInfo = new ArrayList<>();
		String sql = "SELECT * FROM rental_tbl WHERE userId=?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, id);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				int no = this.rs.getInt(1);	
				String userId = this.rs.getString(2);		
				String carCode = this.rs.getString(3); 
				Timestamp sDate = this.rs.getTimestamp(4);	
				Timestamp eDate = this.rs.getTimestamp(5); 
				String place = this.rs.getString(6);		
				String reason = this.rs.getString(7);		
				int price = this.rs.getInt(8);			
				int cost = this.rs.getInt(9);			
				int mileage = this.rs.getInt(10);	
				
				RentalVo rental = new RentalVo(no, userId,carCode, sDate, 
						eDate, place, reason, price, cost, mileage);
				rentalInfo.add(rental);
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
		return rentalInfo;
	}
	
	// Other
	public int getNo() {
		int no = 0;
		String sql = "SELECT MAX(no) FROM rental_tbl";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				no = this.rs.getInt(1);
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
				
		return no;	
	}
}
