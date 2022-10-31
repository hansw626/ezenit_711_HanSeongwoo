package car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

public class CarDao {

	// Member
	private String url;
	private String user;
	private String password;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Constructor
	private CarDao() {
		this.url = "jdbc:mysql://localhost:3306/my_rental_car";
		this.user = "root";
		this.password = "root";
		
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	
	// Single tone Pattern
	private static CarDao instance = new CarDao();
	
	public static CarDao getInstance() {
		return instance;
	}
	
	// CRUD
	
	// 2-1 Read ALL
	public ArrayList<CarDto> getCarList(){
		ArrayList<CarDto> carList = new ArrayList<>();
		String sql = "SELECT * FROM car_tbl";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				String code = this.rs.getString(1);	// 차량 번호판 PK
				String brand = this.rs.getString(2);	// 제조사
				String kind = this.rs.getString(3); 	// 차종
				String model = this.rs.getString(4); 	// 모델명
				int yearly = this.rs.getInt(5); 	// 연식
				String fuel = this.rs.getString(6); 	// 연료
				int price = this.rs.getInt(7);		// 기본 대여료
				int cost = this.rs.getInt(8);		// 주행 거리당 비용
				String img = this.rs.getString(9);		// 모델 사진
				Timestamp regDate = this.rs.getTimestamp(10); 	// 제조 일자
				
				CarDto car = new CarDto(code, brand, kind, model, yearly, fuel, price, cost, img, regDate);
				carList.add(car);
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
		
		return carList;
	}
	
	// 2-2 Read One
	public CarDto getCarByCode(String code) {
		CarDto car = null;
		String sql = "SELECT * FROM car_tbl WHERE `code`=?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, code);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String brand = this.rs.getString(2);	// 제조사
				String kind = this.rs.getString(3); 	// 차종
				String model = this.rs.getString(4); 	// 모델명
				int yearly = this.rs.getInt(5); 	// 연식
				String fuel = this.rs.getString(6); 	// 연료
				int price = this.rs.getInt(7);		// 기본 대여료
				int cost = this.rs.getInt(8);		// 주행 거리당 비용
				String img = this.rs.getString(9);		// 모델 사진
				Timestamp regDate = this.rs.getTimestamp(10); 	// 제조 일자
				
				car = new CarDto(code, brand, kind, model, yearly, fuel, price, cost, img, regDate);
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
		
		return car;
	}
}
