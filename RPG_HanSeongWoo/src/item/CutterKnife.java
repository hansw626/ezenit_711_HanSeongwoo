package item;

public class CutterKnife extends Item implements AssessinMark {
	
	@Override
	public void setItem() {
		name = "커터칼";
		className = "CutterKnife";
		job = "암살자";
		kind = WEAPON;
		att = 6;
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
		System.out.println(" | 공격력 : +" + att + "]");
	}
}
