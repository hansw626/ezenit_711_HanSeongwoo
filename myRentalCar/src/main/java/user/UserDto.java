package user;

import java.sql.Timestamp;

public class UserDto {
	
	// Member
	private String id;	// PK
	private String pw;
	private String name;
	private String license;
	private String phone;
	private String address;
	private Timestamp regDate;
	
	
	// Constructor
	// All Arguments Constructor
	public UserDto(String id, String pw, String name, String license, String phone, String address, Timestamp regDate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.license = license;
		this.phone = phone;
		this.address = address;
		this.regDate = regDate;
	}
	
	public UserDto(String id, String pw, String name, String license, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.license = license;
		this.phone = phone;
		this.address = address;
	}
	// Getter & Setter
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Timestamp getRegDate() {
		return regDate;
	}
	
	
}
