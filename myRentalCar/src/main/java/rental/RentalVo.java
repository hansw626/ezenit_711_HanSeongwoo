package rental;

import java.sql.Timestamp;

public class RentalVo {

	private int no;	// PK
	private String userId;	// FK	
	private String carCode; // FK
	private Timestamp sDate;	// 렌트 시작일
	private Timestamp eDate; 	// 렌트 종료일
	private String place;		// 대여 장소
	private String reason;		// 대여 이유
	private int price;			// 렌트 가격
	private int cost;			// km당 비용
	private int mileage;		// 주행 거리
	
	
	public RentalVo(int no, String userId, String carCode, Timestamp sDate, Timestamp eDate, String place,
			String reason, int price, int cost, int mileage) {
		super();
		this.no = no;
		this.userId = userId;
		this.carCode = carCode;
		this.sDate = sDate;
		this.eDate = eDate;
		this.place = place;
		this.reason = reason;
		this.price = price;
		this.cost = cost;
		this.mileage = mileage;
	}
	
	public RentalVo(String userId, String carCode, Timestamp sDate, Timestamp eDate, String place,
			String reason, int price, int cost) {
		super();
		this.userId = userId;
		this.carCode = carCode;
		this.sDate = sDate;
		this.eDate = eDate;
		this.place = place;
		this.reason = reason;
		this.price = price;
		this.cost = cost;
	}

	public int getNo() {
		return no;
	}


	public String getUserId() {
		return userId;
	}


	public String getCarCode() {
		return carCode;
	}

	public Timestamp getsDate() {
		return sDate;
	}


	public Timestamp geteDate() {
		return eDate;
	}


	public String getPlace() {
		return place;
	}


	public String getReason() {
		return reason;
	}


	public int getPrice() {
		return price;
	}


	public int getCost() {
		return cost;
	}


	public int getMileage() {
		return mileage;
	}
	
	
}
