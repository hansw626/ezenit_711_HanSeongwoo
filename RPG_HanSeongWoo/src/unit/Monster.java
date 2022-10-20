package unit;

public class Monster extends Unit {

	public Monster(String name, int hp, int att, int magic, int def) {
		super(name, hp, att, magic, def);
	}

	@Override
	public void printStatus() {
		System.out.printf("이름 : %s [lv.%d]\n", super.getNAME(), super.getLevel());
		System.out.printf("HP(%d), att(%d), magic(%d), def(%d)\n", 
				super.getMAX_HP(), super.getAtt(), super.getMagic(), super.getDef());
	}

}
