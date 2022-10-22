package guild;

import java.util.ArrayList;

import game.Game;
import hero.Hero;
import inventory.Inventory;
import item.Item;

public class Guild {
	
	private int money;
	ArrayList<Hero> heroList;
	String[] heroJobs;
	Inventory inven;
	
	
	private Guild() {
		money = 10000;
		heroList = new ArrayList<>();
		heroJobs = new String[]{"Warrior", "Tanker", "Assessin"};
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
		

		int level = 1;
		int rNum = Game.ran.nextInt(heroJobs.length);
		try {
			Class<?> clazz = Class.forName("hero." + heroJobs[rNum]);
			Object obj = clazz.newInstance();
			if(obj instanceof Hero) {
				heroList.add((Hero) obj);
				((Hero) obj).setLevel(level);
				((Hero) obj).setStatus();
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
				System.out.printf("[%d번]",i+1);
				heroList.get(i).getInfo();
			}
		}
	}
	
	public void equitedItem(int itemIdx) {
		printHeroList();
		System.out.println("착용시킬 영웅의 번호 : ");
		int idx = Game.scan.nextInt()-1;
		if(idx>=0 && idx<heroList.size()) {
			Hero hero = heroList.get(idx);
			Item item = inven.getItemList().get(itemIdx);
			hero.equitedItem(item);
		}else {
			System.out.println("영웅이 존재하지 않습니다.");
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
