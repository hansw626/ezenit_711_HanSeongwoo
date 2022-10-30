package car;

import java.sql.Timestamp;

public class CarDto {
	
	// Member
	private String code;	// 차량 번호판 PK
	private String brand;	// 제조사
	private String kind; 	// 차종
	private String model; 	// 모델명
	private int yearly; 	// 연식
	private String fuel; 	// 연료
	private int price;		// 기본 대여료
	private int cost;		// 주행 거리당 비용
	private String img;		// 모델 사진
	private Timestamp regDate; 	// 제조 일자
	
	//Constructor
	//All Arguments Constructor
	public CarDto(String code, String brand, String kind, String model, int yearly, String fuel, int price, int cost,
			String img, Timestamp regDate) {
		super();
		this.code = code;
		this.brand = brand;
		this.kind = kind;
		this.model = model;
		this.yearly = yearly;
		this.fuel = fuel;
		this.price = price;
		this.cost = cost;
		this.img = img;
		this.regDate = regDate;
	}

	public String getCode() {
		return code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearly() {
		return yearly;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Timestamp getRegDate() {
		return regDate;
	}
	
	
	
}
