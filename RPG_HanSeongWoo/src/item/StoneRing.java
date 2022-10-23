package item;

public class StoneRing extends Item implements AllMark {
	
	@Override
	public void setItem() {
		name = "돌반지";
		className = "StoneRing";
		job = "모두";
		kind = RING;
		hp = 15;
		att = 3;
		def = 0;
		equited = false;
		level = 1;
		price = 1000;
	}

	@Override
	public void getItemInfo() {
		System.out.println("=====================================");
		System.out.print("[이름 : " + name);
		System.out.print(" | 직업 : " + job + "]");
		System.out.print("[레벨 : " + level);
		System.out.print(" | 체력 : +" + hp);
		System.out.println(" | 공격력 : +" + att);
		System.out.println(" | 공격력 : +" + def + "]");
	}
}
