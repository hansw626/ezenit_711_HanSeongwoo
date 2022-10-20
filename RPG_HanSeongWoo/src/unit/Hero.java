package unit;

import item.Item;

public class Hero extends Unit {

	private Item weapon;
	private Item armor;
	private Item ring;
	
	public Hero(String name, int hp, int att, int magic, int def) {
		super(name, hp, att, magic, def);
		this.weapon = null;
		this.armor = null;
		this.ring = null;
		this.setLevel(1);
	}

	@Override
	public void printStatus() {
		System.out.printf("이름 : %s [lv.%d]\n", super.getNAME(), super.getLevel());
		System.out.printf("HP(%d), att(%d), magic(%d), def(%d)\n", 
				super.getMAX_HP(), super.getAtt(), super.getMagic(), super.getDef());
		System.out.printf("무기(%s), 방어구(%s), 장신구(%s)", weapon==null ? "비어 있음" : weapon.getNAME(),
				armor==null ? "비어 있음" : armor.getNAME(), ring==null ? "비어 있음" : ring.getNAME());
	}

	
}
