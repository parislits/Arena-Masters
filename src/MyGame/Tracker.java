package MyGame;

import javax.swing.JOptionPane;

public class Tracker {
	
	private HeroesCatalog heroesCatalog1;
	private HeroesCatalog heroesCatalog2;
	private HeroesCatalog finalHeroCatalog;
	private Heroes currentHero;
	private int temp;
	private User player1 , player2;
	private Spell[] spellToNextRound=new Spell[10];
	private int sizeOfspellToNextRount=10;
	private GameJ GJ;
	private UserCatalog aUserCat;
	
	
	public Tracker(HeroesCatalog aHeroesCatalog1, HeroesCatalog aHeroesCatalog2,User player1,User player2 ){
		this.player1=player1;
		this.player2=player2;
		finalHeroCatalog=new HeroesCatalog(10);
		heroesCatalog1=aHeroesCatalog1;
		aUserCat=FilesAdministrator.readsUsersOfFile();
		int startCord1[][]=new int[5][2];
		startCord1[0][0]=35;startCord1[0][1]=175;
		startCord1[1][0]=175;startCord1[1][1]=105;
		startCord1[2][0]=315;startCord1[2][1]=105;
		startCord1[3][0]=525;startCord1[3][1]=105;
		startCord1[4][0]=665;startCord1[4][1]=175;
		
		int startCord2[][]=new int[5][2];
		startCord2[0][0]=35;startCord2[0][1]=525;
		startCord2[1][0]=175;startCord2[1][1]=595;
		startCord2[2][0]=385 ;startCord2[2][1]=595;
		startCord2[3][0]=525;startCord2[3][1]=595;
		startCord2[4][0]=665;startCord2[4][1]=525;
		
		
		for(int i=0;i<5;i++){
			int controler = 1;
			heroesCatalog1.getHero(i).setControler(controler);
			
			heroesCatalog1.getHero(i).setXcord(startCord1[i][0]);
			heroesCatalog1.getHero(i).setYcord(startCord1[i][1]);
			finalHeroCatalog.addHero(heroesCatalog1.getHero(i));
			
		}
		heroesCatalog2=aHeroesCatalog2;
		
		for(int i=0;i<5;i++){
			int controler = 2;
			heroesCatalog2.getHero(i).setXcord(startCord2[i][0]);
			heroesCatalog2.getHero(i).setYcord(startCord2[i][1]);
			heroesCatalog2.getHero(i).setControler(controler);	
			finalHeroCatalog.addHero(heroesCatalog2.getHero(i));
		}
		for(int i=0;i<10;i++){
			spellToNextRound[i]=null;
		}
		
		//ταξινομιση αναλογα με το finalHeroCatalog.getHero(i).getInitiative
		//System.out.println(finalHeroCatalog.getSize());
		finalHeroCatalog.SelectionSort();
		
		
		currentHero = finalHeroCatalog.getHero(0);
		 GJ= new GameJ(this);
		
	}
	
	//	Heroes currentHero = finalHeroCatalog.getHero(i);
	//	setCurrentHero(currentHero);
	
	public HeroesCatalog getHeroesCatalog(int player){//0 gia final,1 gia catalog1 ,2 gia catalog2
		
		if(player==0)
			return finalHeroCatalog;
		else if(player==1)
			return heroesCatalog1;
		else if(player==2)
			return heroesCatalog2;
		else
			return null;
	}
	
	public int endTurn(){				//1 νικαει ο Player1, 0 αν συνεχιζεται το παιχνιδι
		int indexofDeadHero=finalHeroCatalog.deleteDeadHero();	//2 νικαει ο Player2
		heroesCatalog1.deleteDeadHero();
		heroesCatalog2.deleteDeadHero();
		
		if(indexofDeadHero!=-1){
			
			for(int i=indexofDeadHero;i<sizeOfspellToNextRount-1;i++){
				
				spellToNextRound[indexofDeadHero]=spellToNextRound[indexofDeadHero+1];
				indexofDeadHero++;
			}
			System.out.println("to size miothike");
			this.sizeOfspellToNextRount--;
		}
		if(heroesCatalog1.getSize() == 0){
			int index=aUserCat.indexOf(player2);
			aUserCat.getUser(index).setMarks(player2.getMarks()+15);
			 index=aUserCat.indexOf(player1);
			aUserCat.getUser(index).setMarks(player1.getMarks()-10);
			FilesAdministrator.writeUserToFile(aUserCat);
			

			new VictoryJf(player2);
			GJ.dispose();
			return 2;
		}
		if(heroesCatalog2.getSize() == 0){
			int index=aUserCat.indexOf(player1);
			aUserCat.getUser(index).setMarks(player1.getMarks()+15);
			index=aUserCat.indexOf(player2);
			aUserCat.getUser(index).setMarks(player2.getMarks()-10);
			FilesAdministrator.writeUserToFile(aUserCat);
			
			

			new VictoryJf(player1);
			GJ.dispose();

			
			return 1;
		}
		
		if(spellToNextRound[temp]!=null){
			spellToNextRound[temp].removeSpellfor(finalHeroCatalog.getHero(temp));
			spellToNextRound[temp]=null;
			JOptionPane.showMessageDialog(null, "this spel remove");

		}
		
		
		temp=(temp+1)%finalHeroCatalog.getSize();
		currentHero = finalHeroCatalog.getHero(temp);
		if(spellToNextRound[temp]!=null)
		if(spellToNextRound[temp].getName()=="Stan"||spellToNextRound[temp].getName()=="StanWithDamage"){
			
			JOptionPane.showMessageDialog(null,getCurrentPlayerName()+" you can't play "+ currentHero.getName()+" has stan");
			//spellToNextRound[temp].removeSpellfor(finalHeroCatalog.getHero(temp));
			spellToNextRound[temp]=null;
			temp=(temp+1)%finalHeroCatalog.getSize();
			currentHero = finalHeroCatalog.getHero(temp);
		}else if(spellToNextRound[temp].getName()=="Cilent"){
			GJ.setMOrC(1);
			
		}
		
		
			
		return 0;
	}
	public void setSpellToNextRound(Heroes aHero,Spell aSpell){
		int index;
		index=finalHeroCatalog.indexOf(aHero);
		
			spellToNextRound[index]=aSpell;

	}

	public Heroes getCurrentHero(){		//επιστρεφει τον ηρωα που παιζει  
		return currentHero;
	}
	
	public int getCurrentPlayer(){		//σε επιστρεφει 1 ή 2 (int)
		return currentHero.getControler();
		
	}
	public String getCurrentPlayerName() {
		if(currentHero.getControler()==1)
			return player1.getName();
		else
			return player2.getName();
		
	}
	

	
}
