package item;

public class ChainArmor extends Item implements AllMark{
	
	@Override
	public void setItem() {
		name = "사슬갑옷";
		className = "ChainArmor";
		job = "모두";
		kind = ARMOR;
		hp = 10;
		att = 0;
		def = 8;
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
