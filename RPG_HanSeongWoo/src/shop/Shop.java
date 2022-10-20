package shop;

import java.util.ArrayList;
import java.util.Scanner;

import Guild.Guild;
import item.Item;
import item.WarriorWeapon;

public class Shop {

	private ArrayList<Item> itemList;
	private Scanner scan;
	
	private Guild guild;
	
	public Shop() {
		itemList = new ArrayList<>();
		itemList.add(new WarriorWeapon().getWoodCutterAxe());
		itemList.add(new WarriorWeapon().getWarriorAxe());
		itemList.add(new WarriorWeapon().getThorAxe());
	}
	
	public void printShopMenu() {
		scan = new Scanner(System.in);
		while (true) {
			System.out.println("=============== [상점] ===============");
			printItems();
			System.out.println("[골드 : " + Guild.getMoney() + "]");
			System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selNum = scan.nextInt();
			if (selNum == 0)
				break;
			
		}
	}
	
	public void printItems() {
		for(int i=0;i<itemList.size();i++) {
			System.out.printf("[%d번] ");
			itemList.get(i).printItemStatus();
		}
	}
}
