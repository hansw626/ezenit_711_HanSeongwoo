package hero;

import item.Item;
import unit.Unit;


public class Hero extends Unit{
	
	private String className;
	private String job;
	private int maxExp;
	private int exp;
	
	private Item weapon;
	private Item armor;
	private Item ring;
	
	private boolean party;
	
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
		System.out.print("[이름 : " + name + "]");
		System.out.println("[직업 : " + job + "]");
		System.out.print(" [레벨 : " + getLevel() + "]");
		System.out.print(" [경험치 : " + exp + "/" + maxExp + "]");
		System.out.print(" [체력 : " + getHp());
		System.out.println(" / " + getHp() + "]");
		System.out.print("[공격력 : " + getAtt() + "]");
		System.out.println(" [방어력 : " + getDef() + "]");
		if(weapon!=null)
			System.out.println(" [무기 : " + weapon.getName() + "]");
		if(armor!=null)
			System.out.println(" [갑옷 : " + armor.getName() + "]");
		if(ring!=null)
			System.out.println(" [반지 : " + ring.getName() + "]");
	}
	
	public void setStatus() {}
	
	public void equitedItem(Item item) {}

	public void levelUp() {}
	
	@Override
	public int getHp() {
		int hp = super.getHp();
		if(weapon !=null)
			hp += weapon.getHp();
		if(armor != null)
			hp += armor.getHp();
		if(ring != null)
			hp += ring.getHp();
		return hp;
	}
	
	@Override
	public int getAtt() {
		int att = super.getAtt();
		if(weapon !=null)
			att += weapon.getAtt();
		if(armor != null)
			att += armor.getAtt();
		if(ring != null)
			att += ring.getAtt();
		
		return att;
	}
	
	@Override
	public int getDef() {
		int def = super.getDef();
		if(weapon !=null)
			def += weapon.getDef();
		if(armor != null)
			def += armor.getDef();
		if(ring != null)
			def += ring.getDef();
		
		return def;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
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
		while(true) {
			if(exp>maxExp) {
				levelUp();
				exp -= maxExp;
			}else {
				break;
			}
		}
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
	
	public boolean getParty() {
		return party;
	}
	
	public void setParty(boolean party) {
		this.party = party;
	}
}

