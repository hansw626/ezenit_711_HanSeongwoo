package utill;

import game.Game;

public class NameGernerator {

	public static String getHeroName() {
		String result = "";
		
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };
		
		result = n1[Game.ran.nextInt(n1.length)];
		result += n2[Game.ran.nextInt(n1.length)];
		result += n3[Game.ran.nextInt(n1.length)];
		
		return result;
	}
	
	public static String getMonsterName() {
		String result = "";
		
		String[] n1 = { "제", "클", "컴", "사", "파", "이", "고" };
		String[] n2 = { "라", "래", "벳", "이", "로", "블", "구" };
		String[] n3 = { "스", "드", "츠", "클", "코", "린", "마" };
		
		result = n1[Game.ran.nextInt(n1.length)];
		result += n2[Game.ran.nextInt(n1.length)];
		result += n3[Game.ran.nextInt(n1.length)];
		
		return result;
	}
}
