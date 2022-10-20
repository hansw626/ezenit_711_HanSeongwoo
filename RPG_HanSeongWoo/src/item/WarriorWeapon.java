package item;

public class WarriorWeapon extends Item {

	public Item getWoodCutterAxe(){
		Item item = new Item();
		item.setItem("나무꾼의 도끼", WEAPON, 4, 1000);
		return item;
	}
	
	public Item getWarriorAxe(){
		Item item = new Item();
		item.setItem("전사의 도끼", WEAPON, 4, 1000);
		return item;
	}
	
	public Item getThorAxe(){
		Item item = new Item();
		item.setItem("토르의 도끼", WEAPON, 4, 1000);
		return item;
	}
}
