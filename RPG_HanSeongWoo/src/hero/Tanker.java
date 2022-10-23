package hero;

import game.Game;
import inventory.Inventory;
import item.AllMark;
import item.Item;
import utill.NameGernerator;
import item.TankerMark;

public class Tanker extends Hero {
	
	private Inventory inven = Inventory.getInstance();
	
	public Tanker() {
		super(NameGernerator.getHeroName(),"탱커", 
				(int) Math.random()*(150)+500,	//hp
				(int) Math.random()*(10)+20,		//att
				(int) Math.random()*(10)+30);		//def
		setClassName("Tanker");
	}
	
	@Override
	public void setStatus() {
		for(int i=0;i<getLevel();i++) {
			setHp((int)(getHp()*1.5));
			setAtt((int)(getAtt()*1.02));
			setDef((int)(getDef()*1.15));
			setMaxExp((int)(getMaxExp()*1.5));
		}
	}
	
	@Override
	public void equitedItem(Item item) {
		if(item instanceof TankerMark || item instanceof AllMark) {		
			if(item.getKind()==Item.WEAPON) {
				if(getWeapon()==null){
					setWeapon(item);
					inven.delItem(item);
				}else {
					System.out.println("이미 착용한 아이템이 있습니다.");
					System.out.println("바꾸시겠습니까? [1:y, 2:n]");
					int sel = Game.scan.nextInt();
					
					if(sel==1) {
						inven.addItem(getWeapon());
						setWeapon(item);
						inven.delItem(item);
					}
				}
			}
			if(item.getKind()==Item.ARMOR) {
				if(getArmor()==null){
					setArmor(item);
					inven.delItem(item);
				}else {
					System.out.println("이미 착용한 아이템이 있습니다.");
					System.out.println("바꾸시겠습니까? [1:y, 2:n]");
					int sel = Game.scan.nextInt();
					
					if(sel==1) {
						inven.addItem(getArmor());
						setArmor(item);
					}
				}
			}
			if(item.getKind()==Item.RING) {
				if(getRing()==null){
					setRing(item);
					inven.delItem(item);
				}else {
					System.out.println("이미 착용한 아이템이 있습니다.");
					System.out.println("바꾸시겠습니까? [1:y, 2:n]");
					int sel = Game.scan.nextInt();
					
					if(sel==1) {
						inven.addItem(getRing());
						setWeapon(item);
					}
				}
			}
		}else {
			System.out.println("해당 영웅이 착용할 수 없는 아이템입니다.");
		}
	}
	
	@Override
	public void levelUp() {
		setMaxExp((int)(getMaxExp()*1.5));
		setLevel(getLevel()+1);
		setStatus();
	}
	
}
