package item;

public class WoodCutterAx extends Item implements Warrior {
	
	@Override
	public void setItem() {
		name = "나무꾼의 도끼";
		kind = WEAPON;
		hp = 10;
		att = 3;
		equited = false;
	}

	@Override
	public void getItemInfo() {
		System.out.println("=====================================");
		System.out.print("[이름 : " + name);
		System.out.print(" | 레벨 : " + level + "]");
		System.out.print(" [체력 : +" + hp);
		System.out.println(" | 공격력 : +" + att + "]");
	}
}
