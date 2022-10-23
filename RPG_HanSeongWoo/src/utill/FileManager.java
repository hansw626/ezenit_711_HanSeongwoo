package utill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import guild.Guild;
import hero.Hero;
import inventory.Inventory;
import item.Item;

public class FileManager {

	private Guild guild = Guild.getInstance();
	private Inventory inven = Inventory.getInstance();
	private String fileName;
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	public FileManager() {
		this.fileName = "text_rpg.txt";
		this.file = new File(fileName);
		this.fw = null;
		this.fr = null;
		this.br = null;
	}
	
	public void saveData() {
		// 돈
		// 인벤토리 아이템
		// 돈/이름,레벨,경험치최대치,경험치,hp,att,def,weapon,armor,ring<br>
		ArrayList<Item> items = inven.getItemList();
		String data = "";
		data += guild.getMoney() + "\n";
		for(int i=0;i<items.size();i++) {
			Item item = items.get(i);
			data += item.getClassName();
			if(i<items.size()-1)
				data += "/";
		}
		data += "\n";
		
		
		ArrayList<Hero> heros = guild.getHeroList();
		for(Hero hero : heros) {
			data += hero.getName();
			data += "," + hero.getClassName();
			data += "," + hero.getMaxExp();
			data += "," + hero.getExp();
			data += "," + hero.getHp();
			data += "," + hero.getAtt();
			data += "," + hero.getDef();
			if(hero.getWeapon()!=null)
				data += "," + hero.getWeapon().getClassName();
			else 
				data += ",null";
			if(hero.getArmor()!=null)
				data += "," + hero.getArmor().getClassName();
			else 
				data += ",null";
			if(hero.getRing()!=null)
				data += "," + hero.getRing().getClassName();
			else 
				data += ",null";
			data += "/";
		}
		
		try {
			this.fw = new FileWriter(this.file);
			this.fw.write(data);
			this.fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadData() {
		try {
			this.fr = new FileReader(file);
			this.br = new BufferedReader(fr);
			
			if(file.exists()) {
				int money = Integer.parseInt(this.br.readLine());
				String[] invenData = br.readLine().split("/");
				String[] herosData = br.readLine().split("/");
				
				guild.setMoney(money);
				if(!invenData[0].equals("")) {
					for(int i=0;i<invenData.length;i++) {
						Class<?> clazz = Class.forName("item." + invenData[i]);
						Object obj = clazz.newInstance();
						
						if(obj instanceof Item) {
							inven.addItem((Item) obj);
						}
					}
				}
				
				if(herosData!=null) {
					for(int i=0;i<herosData.length;i++) {
						String[] hero = herosData[i].split(",");
						Class<?> clazz = Class.forName("hero." + hero[1]);
						Object obj = clazz.newInstance();
						
						if(obj instanceof Hero) {
							((Hero) obj).setName(hero[0]);
							((Hero) obj).setMaxExp(Integer.parseInt(hero[2]));
							((Hero) obj).setExp(Integer.parseInt(hero[3]));
							((Hero) obj).setHp(Integer.parseInt(hero[4]));
							((Hero) obj).setMaxHp(((Hero) obj).getHp());
							((Hero) obj).setAtt(Integer.parseInt(hero[5]));
							((Hero) obj).setDef(Integer.parseInt(hero[6]));
							if(!hero[7].equals("null")) {
								Class<?> itemClazz = Class.forName("item." + hero[7]);
								Object itemObj = itemClazz.newInstance();
								
								if(itemObj instanceof Item) {
									((Item) itemObj).setItem();
									((Hero) obj).setWeapon((Item) itemObj);
								}
							}else {
								((Hero) obj).setWeapon(null);
							}
							if(!hero[8].equals("null")) {
								Class<?> itemClazz = Class.forName("item." + hero[8]);
								Object itemObj = itemClazz.newInstance();
								
								if(itemObj instanceof Item) {
									((Item) itemObj).setItem();
									((Hero) obj).setArmor((Item) itemObj);
								}
							}else {
								((Hero) obj).setArmor(null);
							}
							if(!hero[9].equals("null")) {
								Class<?> itemClazz = Class.forName("item." + hero[9]);
								Object itemObj = itemClazz.newInstance();
								
								if(itemObj instanceof Item) {
									((Item) itemObj).setItem();
									((Hero) obj).setRing((Item) itemObj);
								}
							}else {
								((Hero) obj).setRing(null);
							}
							guild.addHero((Hero) obj);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} {
			
		} 
	}
}
