package shop;

import java.util.ArrayList;

import game.Game;
import inventory.Inventory;
import item.Item;
import item.WoodCutterAx;

public class Shop {

	
	private ArrayList<Item> itemList = new ArrayList<>();
	Inventory inven = Inventory.getInstance();
	
	private Shop() {
		Item item = new WoodCutterAx();
		item.setItem();
		itemList.add(item);
		item = new WoodCutterAx();
		item.setItem();
		itemList.add(item);
	}
	
	private static Shop instance = new Shop();
	
	public static Shop getInstance() {
		return instance;
	}
	
	public void printBuyMenu() {
		if(itemList!=null && itemList.size()>0) {
			System.out.println("========== 상점 ===========");
			for(int i=0;i<itemList.size();i++) {
				Item item = itemList.get(i);
				System.out.printf("[%d 번] ");
				item.getItemInfo();
				System.out.println("[가격 : " + item.getPrice() + "]");
			}
		}
	}
	
	public void printSellMenu() {
		while(true) {
			System.out.println("========== 판매 ==========");
			inven.printItemAll();
			System.out.println("[판매할 품목의 번호] [0 : 돌아가기]");
			int sel = Game.scan.nextInt()-1;
			if(sel==0) {
				break;
			}else {
				boolean sell = inven.sellItem(sel);
				if(!sell) {
					System.out.println("판매가 취소 되었습니다.");
				}
			}
		}
	}
}
