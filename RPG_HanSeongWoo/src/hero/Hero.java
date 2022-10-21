package hero;

import unit.Unit;

public class Hero extends Unit{

	private int level;
	private int maxExp;
	private int exp;
	
//	private Item weapon;
//	private Item armor;
//	private Item ring;
	
	public Hero(String name, int hp, int att, int def) {
		super(name, hp, att, def);
	}
	
	public void getInfo() {
		System.out.println("=====================================");
		System.out.println("[이름 : " + NAME + "]");
		System.out.print(" [레벨 : " + level + "]");
		System.out.print(" [경험치 : " + exp + "/" + maxExp + "]");
		System.out.print(" [체력 : " + getHp());
		System.out.println(" / " + getHp() + "]");
		System.out.print("[공격력 : " + getAtt() + "]");
		System.out.println(" [방어력 : " + getDef() + "]");
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxExp() {
		return maxExp;
	}

	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
}

