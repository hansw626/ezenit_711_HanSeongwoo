package unit;

import item.Item;

public abstract class AbsUnit {
	
	String name;
	int level;
	int hp;
	int maxHp;
	int att;
	int def;
	int exp;
	boolean party;
	Item weapon;
	Item armor;
	Item ring;
	
	abstract void printStatus();
	abstract void printEquitedItem();
}
