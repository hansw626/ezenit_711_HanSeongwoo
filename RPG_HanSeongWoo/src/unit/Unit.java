package unit;

public class Unit {

	public final String NAME;
	
	private int maxHp;
	private int hp;
	private int att;
	private int def;
	
	public Unit(String name, int hp, int att, int def) {
		this.NAME = name;
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

	public String getNAME() {
		return NAME;
	}
	
	
}
