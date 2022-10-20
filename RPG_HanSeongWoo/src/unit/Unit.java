package unit;

public class Unit extends AbsUnit {

	
	
	
	@Override
	void printStatus() {
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + level + "]");
		if (ring != null) {
			System.out.print(" [체력 : " + hp + " + " + ring.power);
		} else {
			System.out.print(" [체력 : " + hp);
		}
		if (ring != null) {
			System.out.println(" / " + maxHp + " + " + ring.power + "]");
		} else {
			System.out.println(" / " + maxHp + "]");
		}
		if (weapon != null) {
			System.out.print("[공격력 : " + att + " + " + weapon.power + "]");
		} else {
			System.out.print("[공격력 : " + att + "]");
		}
		if (armor != null) {
			System.out.print(" [방어력 : " + def + " + " + armor.power + "]");
		} else {
			System.out.print(" [방어력 : " + def + "]");
		}
		System.out.println(" [파티중 : " + party + "]");
	}

	@Override
	void printEquitedItem() {
		if (weapon == null) {
			System.out.println("[무기 : 없음 ]");
		} else {
			System.out.println("[무기 : " + weapon.name + "]");
		}
		if (armor == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + armor.name + "]");
		}
		if (ring == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.println("[반지 : " + ring.name + "]");
		}
	}

}
