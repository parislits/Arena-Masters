package MyGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Main {

	private static final String HeroesCatalog = null;

	public static void main(String[] args) {
		
		//Δημιουργία των Spell 
		String description;
		
		Spell s1 =new Spell("attack", 0, 0, 0, 0,"attack other hero",3);
		Spell s2 =new Spell("TeamHealth4", 0, 4, 0,0,"heal all the team",1);//parametrika 
		Spell s3 =new Spell("TeamHealth1", 0, 1, 0,0,"heal all the team",1);//parametrika 
		Spell s4=new Spell("AttackBoost8", 8, 0, 0,0,"increase damage by 8 more points for one turn",4);
		Spell s5=new Spell("AttackBoost3", 3, 0, 0,0,"increase damage by 3 more points for one turn",4);
		Spell s6=new Spell("DamageBoost",3,0,0,0,"increase damage by 3 more points untill the end",0);
		Spell s7=new Spell("RangeBoost", 0, 0, 5, 0,"increase range by 5 more points for one turn",4);
		Spell s8=new Spell("Stan", 0, 0, 0, 0,"a selected hero loose his turn",4);
		Spell s9=new Spell("StanWithDamage",0,2,0,0,"a selected hero loose his turn and deacrease his health by 2 points",4);
		Spell s10=new Spell("Cilent", 0, 0, 0,0,"a selected hero can't move for the next turn",4);
		Spell s11=new Spell("Health5",0,5,-1,0,"increase health by 5 points",3);
		Spell s12=new Spell("Health10",0,10,-1,0,"increase health by 10 points",3);
		//Spell s8 =new Spell("ForceOfNature",15,0,0,(4,1));//na kano kodika 
		Spell s13=new Spell("SteadyShot",0,0,1,0,"increase range by one point untill the end",0);
		Spell s14=new Spell("selfHealth",0,8,0,0,"increase health by eight points untill the end",0);
		Spell s15=new Spell("DamageWithOutRange",0,5,-1,0,"damages a selected hero for five points regardless range",3);
		Spell s16=new Spell("DamageToAll",7,0,0,0,"damage all heroes for seven points regardless range",2);
		Spell s17=new Spell("SpeedBoost",0,0,0,5,"increase move range",4);
		
		HeroesCatalog allHeroes = new HeroesCatalog(10);  
		//HeroesCatalog allHeroes1 = new HeroesCatalog(5);
		//System.out.println(allHeroes.getSize());
		
		/*ImageIcon a = new ImageIcon("nissa.png");
		Heroes hero = new Heroes("Nissa",a,5,50,6,"attack","Health10","AttackBoost8",4,3);//"AttackBoost8"
		allHeroes.addHero(hero);
		
		ImageIcon a1 = new ImageIcon("tordulf.png");		
		Heroes hero1 = new Heroes("Tordulf",a1,5,80,2,"attack","TeamHealth4","AttackBoost3",4,2);//ForceOfNature
		allHeroes.addHero(hero1);
		
		
		ImageIcon a2 = new ImageIcon("prinia.png");
		Heroes hero2 = new Heroes("Prinia",a2,4,150,2,"attack","TeamHealth1","Stan",2,1);//stan
		allHeroes.addHero(hero2);
		
		ImageIcon a3 = new ImageIcon("thornbow.png");
		Heroes hero3 = new Heroes("Thorn", a3,9, 30, 6, "attack", "SteadyShot","Health5",4, 7);//Health5
		allHeroes.addHero(hero3);
		
		ImageIcon a4 = new ImageIcon("fan-Slug.png");
		Heroes hero4 = new Heroes("Slug", a4,6, 70, 3, "attack", "selfHealth","DamageWithOutRange",4, 4);//damageWithOut 5
		allHeroes.addHero(hero4);
		
		ImageIcon a5 = new ImageIcon("medusa.png");
		Heroes hero5 = new Heroes("Medusa", a5,8, 50, 4, "attack", "StanWithDamage","Cilent", 4,6);//cilent
		allHeroes.addHero(hero5);
		
		ImageIcon a6 = new ImageIcon("darkEld.png");
		Heroes hero6 = new Heroes("Dark Eld", a6, 20, 20, 6, "attack", "AttackBoost3","DamageToAll",3, 9);//damageToall 1/2attack
		allHeroes.addHero(hero6);
		
		ImageIcon a7 = new ImageIcon("emx.png");
		Heroes hero7 = new Heroes("Emx", a7, 8, 35, 7, "attack", "DamageBoost","Stan", 4,8);//stan
		allHeroes.addHero(hero7);
		
		ImageIcon a8 = new ImageIcon("rives.png");
		Heroes hero8 = new Heroes("Rives", a8, 6, 50, 6, "attack", "Health5", "Cilent",6, 5);//cilent
		allHeroes.addHero(hero8);
		
		ImageIcon a9 = new ImageIcon("ginger.png");
		Heroes hero9 = new Heroes("Ginger", a9, 14, 40, 2, "attack", "Cilent","SpeedBoost",6, 10);//moveBoost  
		allHeroes.addHero(hero9);

		
		FilesAdministrator.writeHeroesToFile(allHeroes);*/
		//allHeroes=FilesAdministrator.readsHeroesOfFile(allHeroes);


	
	
	
	

	
	
		
		/*UserCatalog aUserCatalog=new UserCatalog();
		User U1=new User("sotos","sotos");
		U1.setMarks(100);
		aUserCatalog.add(U1);
		User U2=new User("gianis","gianis");
		U2.setMarks(150);
		aUserCatalog.add(U2);
		User U3=new User("kostas","kostas");
		U3.setMarks(200);
		
		aUserCatalog.add(U3);
		//FilesAdministrator.writeUserToFile(aUserCatalog);
		//aUserCatalog.getUser(1).print();
	//	aUserCatalog=FilesAdministrator.readsUserOfFile(aUserCatalog);*/

		//User aUser;
		
		    
		new MainMenuJf();
		//new VictoryJf(U1);
		//new  SelectHeroJf(aUserCatalog, allHeroes, U2, U1);
	//Tracker myT =new Tracker(allHeroes, allHeroes1,U1,U2);
	}
}
