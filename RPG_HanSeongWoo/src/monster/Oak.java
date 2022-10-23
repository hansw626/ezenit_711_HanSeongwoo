package monster;

import utill.NameGernerator;

public class Oak extends Monster {
	
	public Oak() {
		super(NameGernerator.getMonsterName(),
				(int) Math.random()*(50)+200,	//hp
				(int) Math.random()*(20)+50,		//att
				(int) Math.random()*(5)+15);		//def
	}
	
	@Override
	public void setStatus() {
		for(int i=0;i<getLevel();i++) {
			setHp((int)(getHp()*1.5));
			setAtt((int)(getAtt()*1.12));
			setDef((int)(getDef()*1.12));
		}
	}
}
