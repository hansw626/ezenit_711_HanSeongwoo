package item;

public class Item {
	
	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	
	private String name;
	private int kind;
	
	private int power;
	private int price;
	
	public void setItem(String name, int kind, int power, int price) {
		this.name = name;
		this.kind = kind;
		this.power = power;
		this.price = price;
	}

	public void printItemStatus() {
		if(kind==WEAPON)
			System.out.printf("[이름 : %s] [str : +%d] >> %s원\n", name, power, price);
		else if(kind==ARMOR)
			System.out.printf("[이름 : %s] [def : +%d] >> %s원\n", name, power, price);
		else if(kind==RING)
			System.out.printf("[이름 : %s] [HP : +%d] >> %s원\n", name, power, price);
	}
	
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNAME() {
		return name;
	}

	public int getKIND() {
		return kind;
	}
	
	
}
