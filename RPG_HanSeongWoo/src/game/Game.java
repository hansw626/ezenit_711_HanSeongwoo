package game;

import java.util.Random;
import java.util.Scanner;

import guild.Guild;
import inventory.Inventory;
import shop.Shop;
import utill.FileManager;

public class Game {

	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	private Guild guild = Guild.getInstance();
	private Inventory inven = Inventory.getInstance();
	private Shop shop = Shop.getInstance();
	private FileManager fm = new FileManager();	
	
	public void run() {
		while(true) {
			printMainMenu();
			int sel = scan.nextInt();
			
			if(sel==1) {
				while(true) {
					printGuildMenu();
					sel = scan.nextInt();
					if(sel==1) {
						guild.addHero();
					}else if(sel==2) {
						guild.delHero();
					}else if(sel==3) {
						guild.printHeroList();
					}else if(sel==4) {
						while(true) {
							System.out.println("============ 창고 메뉴 ============");
							inven.printItemAll();
							System.out.print("사용할 아이템 번호[돌아가기 : 0] : ");
							int itemIdx = scan.nextInt();
							
							if(itemIdx==0)
								break;
							
							guild.equitedItem(itemIdx-1);
						}
					}else if(sel==5) {
						
					}else if(sel==0) {
						break;
					}					
				}
			}else if(sel==2) {
				while(true) {
					printShopMenu();
					sel = scan.nextInt();
					if(sel==1) {
						while(true) {
							shop.printBuyMenu();
							sel = Game.scan.nextInt();
							
							if(sel==0)
								break;
							
							shop.buyItem(sel-1);
						}
					}else if(sel==2) {
						while(true) {
							shop.printSellMenu();
							sel = Game.scan.nextInt();
							
							if(sel==0)
								break;
							
							shop.sellItem(sel-1);
						}
					}else if(sel==0) {
						break;
					}					
				}
			}else if(sel==3) {
				fm.saveData();
			}else if(sel==4) {
				fm.loadData();
			}else if(sel==0) {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
	}
	
	private void printMainMenu() {
		System.out.println("=============== 메인 메뉴 ===============");
		System.out.println("[1] 길드 관리\t[2] 상점 이동");
		System.out.println("[3] 게임 저장\t[4] 게임 로드");
		System.out.println("[0] 게임 종료");
	}
	
	private void printGuildMenu() {
		System.out.println("=============== 길드 메뉴 ===============");
		System.out.println("[1] 용병 고용\t[2] 용병 방출");
		System.out.println("[3] 용병 정보\t[4] 인벤토리");
		System.out.println("[5] 던전 이동\t[0] 뒤로가기");
	}
	
	private void printShopMenu() {
		System.out.println("=============== 상점 메뉴 ===============");
		System.out.println("[1] 아이템 구매\t[2] 아이템 판매");
		System.out.println("[0] 뒤로가기");
	}
}
