package Guild;

import java.util.ArrayList;

import item.Item;
import unit.Hero;

public class Guild {

	private static int money;
	private ArrayList<Hero> heros;
	private ArrayList<Item> items;
	
	public Guild() {
		this.money = 30000;
		heros = new ArrayList<>();
		items = new ArrayList<>();
	}

	public static int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
