package game;

import java.util.ArrayList;

import guild.Guild;
import hero.Hero;
import monster.Boss;
import monster.Monster;

public class Fight {

	private Guild guild = Guild.getInstance();
	private ArrayList<Hero> heros;
	private ArrayList<Monster> monsters;

	
	public void inFight(ArrayList<Hero> heros) {
		createMonsters();
		int exp = 0;
		int money = 0;
		boolean victory = false;
		boolean defeat = false;
		for(Monster monster : monsters) {
			exp += monster.getLevel()*45; 
			money += monster.getLevel()*500;
		}
		ArrayList<Hero> temp = heros;
		while(true) {
			
			for(Hero hero : temp) {
				int rNum = Game.ran.nextInt(monsters.size());
				Monster monster = monsters.get(rNum);
				int damage = (int)(hero.getAtt() / (monster.getDef()*0.1));
				int hp = monster.getHp() - damage;
				System.out.printf("%s가 %s에게 %d의 데미지를 주었습니다.\n", hero.getName(), monster.getName(), damage);
				if(hp <= 0) {
					System.out.printf("%s가 쓰러졌했습니다.\n", monster.getName());
					monsters.remove(rNum);
				}else {
					monster.setHp(hp);
				}
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(monsters.size()==0) {
					victory = true;
					break;
				}
			}
			
			if(victory) {
				System.out.println("승리!!");
				guild.setMoney(guild.getMoney() + money);
				for(Hero hero : heros) {
					hero.setExp(exp);
					hero.setParty(false);
				}
				break;
			}
			
			for(Monster monster : monsters) {
				int rNum = Game.ran.nextInt(heros.size());
				Hero hero = heros.get(rNum);
				int damage = (int)(monster.getAtt() / hero.getDef());
				int hp = hero.getHp() - damage;
				System.out.printf("%s가 %s에게 %d의 데미지를 주었습니다.\n",monster.getName() , hero.getName(), damage);
				if(hp <= 0) {
					System.out.printf("%s가 쓰러졌했습니다.\n", hero.getName());
					heros.remove(rNum);
				}else {
					hero.setHp(hp);
				}
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(temp.size()==0) {
					defeat = true;
					break;
				}
			}
			
			
			if(defeat) {
				System.out.println("패배..");
				break;
			}
			
			
		}
	}
	
	public void createMonsters() {
		monsters = new ArrayList<Monster>();
		String[] monList = {"Oak","Wolf","Bat"};
		
		for(int i=0;i<3;i++) {
			int rNum = Game.ran.nextInt(monList.length);
			try {
				Class<?> clazz = Class.forName("monster." + monList[rNum]);
				Object obj = clazz.newInstance();
				if(obj instanceof Monster) {
					Monster monster = (Monster) obj;
					rNum = Game.ran.nextInt(10);
					if(rNum==0) {
						Boss boss = new Boss(monster);
						monsters.add(boss);
					}else {
						monsters.add(monster);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
