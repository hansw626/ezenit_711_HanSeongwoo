package utill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import guild.Guild;
import inventory.Inventory;

public class FileManager {

	private Guild guild = Guild.getInstance();
	private Inventory inven = Inventory.getInstance();
	private String fileName;
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	
	public void saveData() {
		
	}
}
