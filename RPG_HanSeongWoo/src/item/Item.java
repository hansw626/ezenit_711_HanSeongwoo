package item;

interface Warrior {
	// mark interface
}

interface Tanker {
	// mark interface
}

interface Assesin {
	// mark interface
}

public abstract class Item {

	public static final int WEAPON = 1;
	public static final int ARMOR = 1;
	public static final int RING = 1;
	String name;
	String className;
	static int level;
	static int kind;
	static int hp;
	static int att;
	static int def;
	static int price;
	boolean equited;
	
	public abstract void setItem();
	public abstract void getItemInfo();
	public String getName() {
		return name;
	}
	public static int getLevel() {
		return level;
	}
	public static int getKind() {
		return kind;
	}
	public static int getHp() {
		return hp;
	}
	public static int getAtt() {
		return att;
	}
	public static int getDef() {
		return def;
	}
	public static int getWeapon() {
		return WEAPON;
	}
	public static int getArmor() {
		return ARMOR;
	}
	public static int getRing() {
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

