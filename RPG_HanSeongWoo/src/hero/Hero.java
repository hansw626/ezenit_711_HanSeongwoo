package hero;

import item.Item;
import unit.Unit;


public class Hero extends Unit{
	
	private String job;
	private int level;
	private int maxExp;
	private int exp;
	
	private Item weapon;
	private Item armor;
	private Item ring;
	
	public Hero(String name, String job, int hp, int att, int def) {
		super(name, hp, att, def);
		this.job = job;
		this.maxExp = 100;
		weapon = null;
		armor = null;
		ring = null;
	}
	
	public void getInfo() {
		System.out.println("=====================================");
		System.out.print("[이름 : " + NAME + "]");
		System.out.println("[직업 : " + job + "]");
		System.out.print(" [레벨 : " + level + "]");
		System.out.print(" [경험치 : " + exp + "/" + maxExp + "]");
		System.out.print(" [체력 : " + getHp());
		System.out.println(" / " + getHp() + "]");
		System.out.print("[공격력 : " + getAtt() + "]");
		System.out.println(" [방어력 : " + getDef() + "]");
		if(weapon!=null)
			System.out.println(" [무기 : " + weapon.getName() + "]");
		if(armor!=null)
			System.out.println(" [무기 : " + armor.getName() + "]");
		if(ring!=null)
			System.out.println(" [무기 : " + ring.getName() + "]");
	}
	
	public void setStatus() {}
	
	public void equitedItem(Item item) {}
	
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

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}
	
	public String getJob() {
		return job;
	}
}

