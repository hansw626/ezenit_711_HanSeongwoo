package monster;

import game.Game;

public class Boss extends Monster{

	private String[] monsters = {"Ock","Wolf","Zombie"};
	private int rNum = Game.ran.nextInt(monsters.length);
	
	public Boss(Monster monster) {
		super(monster.getNAME(), monster.getHp()*2, 
				(int) (monster.getAtt()*1.5), (int) (monster.getDef()*1.5));
	}
	
	

}
