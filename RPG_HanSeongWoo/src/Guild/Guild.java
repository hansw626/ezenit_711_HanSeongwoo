package Guild;

import java.util.ArrayList;

import item.Item;
import unit.Hero;

public class Guild {

	private int money;
	private ArrayList<Hero> heros;
	private ArrayList<Item> items;
	
	public Guild() {
		this.money = 30000;
		heros = new ArrayList<>();
		items = new ArrayList<>();
	}
	

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void addHero(Hero hero) {
		heros.add(hero);
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
}
