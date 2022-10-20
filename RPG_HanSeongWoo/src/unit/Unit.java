package unit;

// Monster 와 Hero의 공통분모
public abstract class Unit {
	
	public final String NAME;
	
	private int level;
	private int max_hp;
	private int hp;		// 체력
	private int att;	// 공격력
	private int magic;	// 마법공격력
	private int def;	// 방어력
	private int dex;	// 민첩 (치명타 확률, 회피율)
	
	public Unit(String name, int hp, int att, int magic, int def) {
		this.NAME = name;
		this.max_hp = hp;
		this.hp = hp;
		this.att = att;
		this.magic = magic;
		this.def = def;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public int getMagic() {
		return magic;
	}
	
	public void setMagic(int magic) {
		this.magic = magic;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public String getNAME() {
		return NAME;
	}

	public int getMAX_HP() {
		return max_hp;
	}

	public abstract void printStatus();
}
