package monster;

import game.Game;

public class Boss extends Monster{
	
	public Boss(Monster monster) {
		super(monster.getName(), monster.getHp()*2, 
				(int) (monster.getAtt()*1.5), (int) (monster.getDef()*1.5));
	}
	
	

}
