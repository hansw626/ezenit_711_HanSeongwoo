package inventory;

import java.util.ArrayList;
import java.util.Scanner;

import item.Item;

public class Inventory {
	ArrayList<Item> itemList = new ArrayList<>();
	private Scanner scan;

	public void inventoryMenu() {
		scan = new Scanner(System.in);
		while (true) {
			System.out.println("============ [인벤메뉴] =============");
			printItemList();
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 0)
				break;
			if (sel == 1) {
				equipMenu();
			}
			if (sel == 2) {
				sellMenu();
			}
		}
	}
	
	public void equipMenu() {
		
	}
	
	public void sellMenu() {
		
	}
	
	public void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).name + "]");
			System.out.print("[능력 : " + itemList.get(i).power + "]");
			System.out.print("[가격 : " + itemList.get(i).price + "]");
			System.out.println("");
		}
	}
}
