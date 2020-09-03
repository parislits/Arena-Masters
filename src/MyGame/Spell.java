package MyGame;

import java.io.Serializable;
import java.util.ArrayList;

public class Spell implements Serializable{
	private String name;
	private int damage;
	private int health;
	private int range;
	private int speed;
	private int to;//an 0 ston euato tou an 1 stous sumpektes 2 stous antipalous an 3 se enan allo pexti 4 se enan antipalo gia ton epomeno giro
	private String description;
	private String info;
	private static ArrayList<Spell> allSpel=new ArrayList<Spell>();
	
	public Spell (String aName,int aDamage,int aHealth,int aRange,int aSpeed,String anInfo,int to){
		name=aName;
		damage=aDamage;
		health=aHealth;
		range=aRange;
		speed=aSpeed;
		info=anInfo;
		this.to=to;
		allSpel.add(this);
		
	}
	public void doSpelltoMe(Heroes curentHero){
		curentHero.setDamage(curentHero.getDamage()+this.damage);
		curentHero.setHealth(curentHero.getHealth()+this.health);
		curentHero.setRange(curentHero.getRange()+this.range);
		
	}
	
	public boolean doSpellto1(Heroes heroTurn,Heroes heroSelected,int x,int y){

		if(heroTurn.inTheRange(x, y)&&this.range!=-1){
			
			heroSelected.setHealth(heroSelected.getHealth()-heroTurn.getDamage());

		}
		else if(this.range!=-1)
			return false;
		
			heroSelected.setHealth(heroSelected.getHealth()+this.health);
			heroSelected.setHealth(heroSelected.getHealth()-this.damage);
			
			return true;
	}
	public void doSpelltoOneTeam(HeroesCatalog aHeroesCatalog){
		for(int i=0;i<aHeroesCatalog.getSize();i++){
			
			Heroes aHero=aHeroesCatalog.getHero(i);
			aHero.setHealth(aHero.getHealth()+health);
			aHero.setHealth(aHero.getHealth()-this.damage);
			
		}
		
	}
	
	public void doSpellForNextRound(Heroes heroTurn,Heroes heroSelected,Tracker myT){
		myT.setSpellToNextRound(heroSelected, this);
		heroSelected.setDamage(heroSelected.getDamage()+damage);
		heroSelected.setHealth(heroSelected.getHealth()-this.health);
		heroSelected.setRange(heroSelected.getRange()+range);
		heroSelected.setSpeed(heroSelected.getSpeed()+this.speed);
		
	}
	public void removeSpellfor(Heroes aHero){
		aHero.setDamage(aHero.getDamage()-damage);
		aHero.setRange(aHero.getRange()-range);
	}

	public int getTo(){
		return to;
	}

	public static ArrayList<Spell> getAllSpel() {
		return allSpel;
	}

	public String getName() {
		return name;
	}
	
	public String getInfo(){
		return info;
	}
	
	public static Spell searchSpell(String aName){
		for(int i=0;i<Spell.getAllSpel().size();i++){
		Spell aSpell=Spell.getAllSpel().get(i);	
			if(aSpell.getName().equals(aName))
					return aSpell;
		}
		
		return null;
	}
}
