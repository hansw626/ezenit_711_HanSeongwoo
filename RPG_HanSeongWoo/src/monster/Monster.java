package monster;

import unit.Unit;

public class Monster extends Unit{

	public Monster(String name, int hp, int att, int def) {
		super(name, hp, att, def);
	}

	public void getInfo() {
		System.out.println("=====================================");
		System.out.print("[이름 : " + getName() + "]");
		System.out.print(" [레벨 : " + getLevel() + "]");
		System.out.print(" [체력 : " + getHp());
		System.out.println(" / " + getHp() + "]");
		System.out.print("[공격력 : " + getAtt() + "]");
		System.out.println(" [방어력 : " + getDef() + "]");
	}
	
	public void setStatus() {}
}
