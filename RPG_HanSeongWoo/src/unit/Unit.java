package unit;

public class Unit {

	public String name;	
	private int maxHp;
	private int hp;
	private int att;
	private int def;
	private int level;
	
	public Unit(String name, int hp, int att, int def) {
		this.name = name;
		this.maxHp = hp;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
