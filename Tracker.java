package MyGame;

public class Tracker {
	
	private HeroesCatalog heroesCatalog1;
	private HeroesCatalog heroesCatalog2;
	private HeroesCatalog finalHeroCatalog;
	private Heroes currentHero;
	
	public Tracker(HeroesCatalog aHeroesCatalog1, HeroesCatalog aHeroesCatalog2 ){
		
		heroesCatalog1=aHeroesCatalog1;
		for(int i=0;i<5;i++){
			int controler = 1;
			heroesCatalog1.getHero(i).setControler(controler);
			finalHeroCatalog.addHero(heroesCatalog1.getHero(i));
		}
		heroesCatalog2=aHeroesCatalog2;
		for(int i=0;i<5;i++){
			int controler = 2;
			heroesCatalog1.getHero(i).setControler(controler);	
			finalHeroCatalog.addHero(heroesCatalog2.getHero(i));
		}
		//ταξινομιση αναλογα με το finalHeroCatalog.getHero(i).getInitiative
	}
	
	//	Heroes currentHero = finalHeroCatalog.getHero(i);
	//	setCurrentHero(currentHero);
	
	public HeroesCatalog getHeroesCatalog(){
		return finalHeroCatalog;		//επιστρεφει τον τελικο 10θεσιο πινακα 
	}
	
	public void setCurrentHero(Heroes aHero){
		this.currentHero = aHero;
	}
	
	public Heroes getCurrentHero(){		//επιστρεφει τον ηρωα που παιζει  
		return currentHero;
	}
	//για να παρεις τον παιχτη που παιζεi	>>>	Tracker.getCurrentHero.getControler
	//											σε επιστρεφει 1 ή 2 (int)
	

	public boolean checkDeadHero(Heroes aHero){
		if(aHero.getHealth()==0){			
			return true;
		}
		else{return false;}
	}
	public void removeDeadHero(Heroes aHero){
		if(this.checkDeadHero(aHero)){
			finalHeroCatalog.deleteItem(aHero);	//μεθοδος που ελεγχει αν ενας ηρωας ειναι νεκρος
		}										//και στελνει στην HeroesCatalog να τον σβησει
	}


}
