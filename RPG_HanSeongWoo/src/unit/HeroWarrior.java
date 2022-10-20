package unit;


import util.NameGernerator;

public class HeroWarrior extends Hero {

	private final static int MAX_HP = 100;
	private final static int MIN_HP = 80;
	private final static int MAX_ATT = 12;
	private final static int MIN_ATT = 7;
	private final static int MAX_MAGIC = 2;
	private final static int MIN_MAGIC = 0;
	private final static int MAX_DEF = 7;
	private final static int MIN_DEF = 5;
	
	public HeroWarrior(String name, int hp, int att, int magic, int def) {
		super(NameGernerator.getHeroName(), 
				(int) Math.floor(Math.random()*(MAX_HP-MIN_HP)+MIN_HP),
				(int) Math.floor(Math.random()*(MAX_ATT-MIN_ATT)+MIN_ATT),
				(int) Math.floor(Math.random()*(MAX_MAGIC-MIN_MAGIC)+MIN_MAGIC),
				(int) Math.floor(Math.random()*(MAX_DEF-MIN_DEF)+MIN_DEF)
		);
	}	
}