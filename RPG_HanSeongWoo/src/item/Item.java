package item;



public abstract class Item {

	public static final int WEAPON = 1;
	public static final int ARMOR = 2;
	public static final int RING = 3;
	String name;
	String className;
	String job;
	int level;
	int kind;
	int hp;
	int att;
	int def;
	int price;
	boolean equited;
	
	public abstract void setItem();
	public abstract void getItemInfo();
	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public int getKind() {
		return kind;
	}
	public int getHp() {
		return hp;
	}
	public int getAtt() {
		return att;
	}
	public int getDef() {
		return def;
	}
	public int getWeapon() {
		return WEAPON;
	}
	public int getArmor() {
		return ARMOR;
	}
	public int getRing() {
		return RING;
	}
	public int getPrice() {
		return price;
	}
	public boolean getEquited() {
		return equited;
	}
	public void setEquited(boolean b) {
		this.equited = b;
	}
	public String getClassName() {
		return className;
	}
	
	
}

