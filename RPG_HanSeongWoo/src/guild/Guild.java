package guild;

import java.util.ArrayList;

import game.Game;
import hero.Hero;
import inventory.Inventory;

public class Guild {
	
	private int money;
	ArrayList<Hero> heroList;
	String[] heroJobs;
	Inventory inven;
	
	
	private Guild() {
		money = 10000;
		heroList = new ArrayList<>();
		heroJobs = new String[]{"Warrior", "Tanker", "Assesin"};
		inven = Inventory.getInstance();
	}
	
	private static Guild instance = new Guild();
	
	public static Guild getInstance() {
		return instance;
	}
	
	public void addHero() {
		System.out.println("5000 길드 머니로 용병을 고용하시겠습니까? [y:1]");
		int sel = Game.scan.nextInt();
		if (money < 5000 || sel!=1)
			return;
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };

		String name = n1[Game.ran.nextInt(n1.length)];
		name += n2[Game.ran.nextInt(n1.length)];
		name += n3[Game.ran.nextInt(n1.length)];
		int ran = Game.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		
		int rNum = Game.ran.nextInt();
		try {
			Class<?> clazz = Class.forName(heroJobs[rNum]);
			Object obj = clazz.newInstance();
			obj = new Hero(name, hp, att, def);
			if(obj instanceof Hero) {
				heroList.add((Hero) obj);
				((Hero) obj).getInfo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		money -= 5000;
	}
	
	public void delHero() {
		printHeroList();
		System.out.print("방출할 영웅의 번호 : ");
		int idx = Game.scan.nextInt()-1;
		heroList.remove(idx);
		System.out.println("영웅을 방출했습니다.");
	}
	
	public void printHeroList() {
		if(heroList!=null) {
			for(int i=0;i<heroList.size();i++) {
				Hero hero =  heroList.get(i);
				System.out.printf("[%d 번] [%s (hp : %d, att : %d, def : %d"
						, i+1,hero.getHp(), hero.getAtt(), hero.getDef());
			}
		}
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public String[] getHeroJobs() {
		return heroJobs;
	}


	public Inventory getInven() {
		return inven;
	}


	public ArrayList<Hero> getHeroList() {
		return heroList;
	}
	
	
}
