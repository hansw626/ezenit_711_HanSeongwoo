package monster;

import utill.NameGernerator;

public class Wolf extends Monster {
	
	public Wolf() {
		super(NameGernerator.getMonsterName(),
				(int) Math.random()*(80)+100,		//hp
				(int) Math.random()*(20)+40,		//att
				(int) Math.random()*(10)+10);		//def
	}
	
	@Override
	public void setStatus() {
		for(int i=0;i<getLevel();i++) {
			setHp((int)(getHp()*1.5));
			setAtt((int)(getAtt()*1.25));
			setDef((int)(getDef()*1.12));
		}
	}
}
