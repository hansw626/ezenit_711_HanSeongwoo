package util;

import java.util.Random;

public class NameGernerator {
	
	private static Random ran;
	public static String getHeroName() {
		ran = new Random();
		String[] a = {"김","이","박","한","황","유","홍","차"};
		String[] b = {"이","승","혜","효","태","지","제","태"};
		String[] c = {"나","기","원","주","진","태","홍","현"};
		
		
		String name = a[ran.nextInt(8)];
		name = b[ran.nextInt(8)];
		name = c[ran.nextInt(8)];
		return name;
	}
	
	public static String getMonsterName() {
		Random ran = new Random();
		String[] a = {"제","이","클","코","캐","알","차","개"};
		String[] b = {"라","블","레","발","치","라","일","롤"};
		String[] c = {"드","린","드","트","볼","뷰","드","트"};
		
		String name = a[ran.nextInt(8)];
		name = b[ran.nextInt(8)];
		name = c[ran.nextInt(8)];
		return name;
	}
}
