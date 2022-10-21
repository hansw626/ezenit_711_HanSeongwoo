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
		// 아이템이름
		// 돈/이름,레벨,경험치최대치,경험치,hp,att,def,weapon,armor,ring<br>
		ArrayList<Item> items = inven.getItemList();
		String data = "";
		data += guild.getMoney() + "\n";
		
		for(Item item : items)
				data += item.getClassName() + "/";	
		data = data.substring(data.length()-1);
		data += "\n";
		
		ArrayList<Hero> heros = guild.getHeroList();
		for(Hero hero : heros) {
			data += "/" + hero.getNAME();
			data += "," + hero.getMaxExp();
			data += "," + hero.getExp();
			data += "," + hero.getHp();
			data += "," + hero.getAtt();
			data += "," + hero.getDef();
			data += "," + hero.getWeapon().getClassName();
			data += "," + hero.getArmor().getClassName();
			data += "," + hero.getRing().getClassName();
			data += "<div>";
		}
		
		try {
			fw = new FileWriter(file);
			fw.write(data);
			fw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
