package shop;

import java.util.ArrayList;

import guild.Guild;
import inventory.Inventory;
import item.CutterKnife;
import item.Item;
import item.WoodCutterAx;
import item.Woodshield;

public class Shop {

	
	private ArrayList<Item> itemList = new ArrayList<>();
	Guild guild = Guild.getInstance();
	Inventory inven = Inventory.getInstance();
	private String[] items = {"WoodCutterAx", "CutterKnife", "Woodshield", "ChainArmor", "StoneRing"};
	
	private Shop() {
		for(int i=0;i<items.length;i++) {
			Class<?> clazz;
			try {
				clazz = Class.forName("item." + items[i]);
				Object obj = clazz.newInstance();
				if(obj instanceof Item) {
					((Item) obj).setItem();
					itemList.add((Item) obj);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
				System.out.printf("[%d 번] ", i+1);
				item.getItemInfo();
				System.out.println("[가격 : " + item.getPrice() + "]");
				System.out.println("[길드 머니 : " + guild.getMoney() + "]");
			}
			System.out.print("구매할 아이템[돌아가기 : 0] : ");
		}
	}
	
	public void buyItem(int sel) {
		int money = guild.getMoney();
		int price = itemList.get(sel).getPrice();
		
		if(money>price) {
			guild.setMoney(money-price);
			inven.addItem(itemList.get(sel));
			System.out.println("해당 아이템을 길드창고로 이동시켰습니다.");
		}else {
			System.out.println("길드 머니가 충분하지 않습니다.");
		}
	}
	
	public void printSellMenu() {
		System.out.println("========== 판매 ==========");
		inven.printItemAll();
		System.out.println("[판매할 품목의 번호] [0 : 돌아가기]");
	}
	
	public void sellItem(int sel) {
		int money = inven.delItem(sel);
		
		if(money!=0) {
			guild.setMoney(guild.getMoney() + money);
			System.out.println("판매되었습니다.");
		}else {
			System.out.println("창고에 없는 아이템입니다.");
		}
	}
}
