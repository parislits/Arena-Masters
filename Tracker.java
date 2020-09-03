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
		//���������� ������� �� �� finalHeroCatalog.getHero(i).getInitiative
	}
	
	//	Heroes currentHero = finalHeroCatalog.getHero(i);
	//	setCurrentHero(currentHero);
	
	public HeroesCatalog getHeroesCatalog(){
		return finalHeroCatalog;		//���������� ��� ������ 10����� ������ 
	}
	
	public void setCurrentHero(Heroes aHero){
		this.currentHero = aHero;
	}
	
	public Heroes getCurrentHero(){		//���������� ��� ���� ��� ������  
		return currentHero;
	}
	//��� �� ������ ��� ������ ��� �����i	>>>	Tracker.getCurrentHero.getControler
	//											�� ���������� 1 � 2 (int)
	

	public boolean checkDeadHero(Heroes aHero){
		if(aHero.getHealth()==0){			
			return true;
		}
		else{return false;}
	}
	public void removeDeadHero(Heroes aHero){
		if(this.checkDeadHero(aHero)){
			finalHeroCatalog.deleteItem(aHero);	//������� ��� ������� �� ���� ����� ����� ������
		}										//��� ������� ���� HeroesCatalog �� ��� ������
	}


}
