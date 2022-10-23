package item;

public class Woodshield extends Item implements TankerMark {
	
	@Override
	public void setItem() {
		name = "나무 방패";
		className = "woodshield";
		job = "탱커";
		kind = WEAPON;
		hp = 5;
		def = 5;
		att = 2;
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
