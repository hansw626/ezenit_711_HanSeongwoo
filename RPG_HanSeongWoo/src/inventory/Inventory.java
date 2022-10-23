package inventory;

import java.util.ArrayList;

import guild.Guild;
import item.Item;

public class Inventory {

	private static final int MAX_SIZE = 10;
	ArrayList<Item> itemList = new ArrayList<>();
	private Guild guild = Guild.getInstance();
	
	private Inventory() {}
	
	private static Inventory instance = new Inventory();
	
	public static Inventory getInstance() {
		return instance;
	}
	
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	public int delItem(int idx) {
		int money = 0;
		if(idx>=0 && idx<itemList.size()) {
			money = (int) (itemList.get(idx).getPrice()/3);
			itemList.remove(idx);
		}
		return money;
	}
	
	public int delItem(Item item) {
		int money = 0;
		for(int i=0;i<itemList.size();i++) {
			Item temp = itemList.get(i);
			if(temp.equals(item)) {
				money = (int) (temp.getPrice()/3);
				itemList.remove(i);
				break;
			}
		}
		return money;
	}
	
	public void printItemAll() {
		if(itemList!=null && itemList.size()>0) {
			for(int i=0;i<itemList.size();i++) {
				Item item = itemList.get(i);
				System.out.printf("[%d 번] ", i+1);
				item.getItemInfo();
			}
		}else {
			System.out.println("비어 있습니다.");
		}
	}
	
	public ArrayList<Item> getItemList(){
		return itemList;
	}
	
}
