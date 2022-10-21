package inventory;

import java.util.ArrayList;

import game.Game;
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
	
	public boolean buyItem(Item item) {
		boolean add = true;
		if(itemList.size()<MAX_SIZE) {
			if(item.getPrice()>guild.getMoney()) {
				System.out.println("길드 머니가 부족합니다.");
			}else {				
				guild.setMoney(guild.getMoney()-item.getPrice());
				itemList.add(item);
				System.out.println("장비를 길드 창고에 비치했습니다.");
			}
		}else {
			System.out.println("창고 공간이 부족합니다.");
			add = false;
		}
		
		return add;
	}
	
	public boolean sellItem(int idx) {
		boolean sell = true;
		
		if(idx<0 || idx>=itemList.size()) {
			sell = false;
			System.out.println("판매할 상품이 없습니다.");
		}else {
			int money = (int)(itemList.get(idx).getPrice()/3);
			System.out.print(money + "길드 머니에 판매하시겠습니까? [1:y]");
			int sel = Game.ran.nextInt();
			if(sel==1) {
				guild.setMoney(guild.getMoney() + money);
				itemList.remove(idx);
			}else {
				sell = false;
			}
		}
		
		return sell;
	}
	
	public void printItemAll() {
		if(itemList!=null && itemList.size()>0) {
			for(int i=0;i<itemList.size();i++) {
				Item item = itemList.get(i);
				System.out.printf("[%d 번] ");
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
