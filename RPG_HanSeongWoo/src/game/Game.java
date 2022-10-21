package game;

import java.util.Random;
import java.util.Scanner;

import guild.Guild;
import inventory.Inventory;
import shop.Shop;

public class Game {

	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();
	private Guild guild = Guild.getInstance();
	private Inventory inven = Inventory.getInstance();
	private Shop shop = Shop.getInstance();
	
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
						inven.printItemAll();
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
						shop.printBuyMenu();
					}else if(sel==2) {
						shop.printSellMenu();
					}else if(sel==0) {
						break;
					}					
				}
			}else if(sel==3) {
				
			}else if(sel==4) {
				
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
