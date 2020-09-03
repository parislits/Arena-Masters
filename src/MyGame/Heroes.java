package MyGame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Heroes implements Serializable{

	private String name;
	private int damage;
	private int health;
	private int range;
	private ImageIcon myIcon;
	private int xcord;
	private int ycord;
	private Spell spel1,spel2,spel3;
	private int controler; //αποθήκευση του παίκτη ο οποίος χειρίζεται τον συγκεκριμένο ήρωα (1=Player1, 2=Player2)
	private Integer initiative;
	private int speed;
	
	public Heroes(String aName,ImageIcon aIcon, int aDamage,int aHealth ,int aRange,String Spel1Name,String spel2Name,String spel3Name,int aSpeed,int aInitiative){
		
		name=aName;
		myIcon=aIcon;
		damage=aDamage;
		health=aHealth;
		range=aRange;
		speed=aSpeed;
		
	
		initiative=aInitiative;
		

		this.spel1=Spell.searchSpell(Spel1Name);	
		this.spel2=Spell.searchSpell(spel2Name);
		this.spel3=Spell.searchSpell(spel3Name);
		
	}
	
	public Spell getSpel2() {
		return spel2;
	}

	public boolean inTheRange(int clicXcord,int clicYcord){
		//Δέχεται 2 συντεταγμένες clicXcord, clicYcord και ελέγχει αν αυτές είναι στα πλαίσια του Range κάθε ήρωα
		int d;
		int x=xcord;		
		int y=ycord;
		d=(int) Math.sqrt(Math.pow(x-clicXcord, 2)+Math.pow(y-clicYcord,2)); //υπολογισμός της απόστασης ανάμεσα στις συντεταγμένες που έχει δεχτεί και τις συντεταγμένες του ήρωα
		
		if(d<=range*70)
			return true;
		else 
			return false;
		
	}
	public boolean inMoveRange(int clicXcord,int clicYcord){
		//Δέχεται 2 συντεταγμένες clicXcord, clicYcord και ελέγχει αν αυτές είναι στα πλαίσια του ΜoveRange κάθε ήρωα
		int d;
		int x=xcord;			
		int y=ycord;
		d=(int) Math.sqrt(Math.pow(x-clicXcord, 2)+Math.pow(y-clicYcord,2));
		
		if(d<=speed*70)
			return true;
		else 
			return false;
		
	} 
	public int getSpeed(){
		return speed;
	}
	
	public String getName() {
		return name;
	}
	public int getDamage() {
		return damage;
	}
	public int getHealth() {
		return health;
	}
	public ImageIcon getMyIcon() {
		return myIcon;
	}
	public int getRange() {
		return range;
	}
	public int getxcord() {
		return xcord;
	}
	public int getycord() {
		return ycord;
	}
	
	//Μετατροπή των συντεταγμένων που έχει δεχτεί η μέθοδος ώστε να συμμορφώνονται στο πρότυπο των υπολοίπων συντεταγμένων όλων των ηρώων
	public void setXcord(int xcord) {
		this.xcord = xcord-xcord%70+35;
	}
	public void setYcord(int ycord) {
		this.ycord = ycord-ycord%70+35;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public Spell getSpel1() {
		return spel1;
	}
	public Spell getSpel3() {
		return spel3;
	}

	public void setControler(int controler) {
		this.controler = controler;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getControler() {
		return controler;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}


}
