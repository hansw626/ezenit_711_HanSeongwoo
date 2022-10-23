package monster;

import utill.NameGernerator;

public class Bat extends Monster {
	
	public Bat() {
		super(NameGernerator.getMonsterName(),
				(int) Math.random()*(20)+50,	//hp
				(int) Math.random()*(20)+50,		//att
				(int) Math.random()*(3)+5);		//def
	}
	
	@Override
	public void setStatus() {
		for(int i=0;i<getLevel();i++) {
			setHp((int)(getHp()*1.3));
			setAtt((int)(getAtt()*1.12));
			setDef((int)(getDef()*1.12));
		}
	}
}
