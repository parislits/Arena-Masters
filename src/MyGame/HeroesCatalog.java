package MyGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.ImageIcon;

public class HeroesCatalog implements Serializable {
	
	private Heroes[] aHeroesCatalog;
	private int index=0;
	private int size;

	
	public HeroesCatalog(int size){
		this.size=size;
		aHeroesCatalog=new Heroes[size];
		for(int i=0;i<size;i++)
			aHeroesCatalog[i]=null;
	}
	public Heroes getHero(int i){
		if(i<size){
			
			return aHeroesCatalog[i];
		}
		else
			return null;
	}
	//�������� ��� ���� ���� ������� ���� ��� ���������
	public void addHero(Heroes aHero){
		if(index<size){
			
			aHeroesCatalog[index]=aHero;
			index++;
		}
	}
	//�������� ��� ���� ���� ������������ ���� ��� ���������
	public void addHero(int aIndex,Heroes aHero ){
		if(aIndex<size)
			aHeroesCatalog[aIndex]=aHero;
	}
	public int getSize(){
		return this.size;
	}

	//�������� ��� ����� �� 0 Health
	public int deleteDeadHero(){
		for(int i=0;i<this.getSize();i++){
			if(this.getHero(i).getHealth()<=0){
				this.remove(i);
				return i;
			}
		}
		return -1;
	}
	//���������� ��� ���� ��� ��������� ���� ������������� ��� �������, ������ ���������� null
	public Heroes checkForHero(int x,int y){
		for( int i=0;i< this.size;i++){
			if(this.getHero(i).getxcord()==x && this.getHero(i).getycord()==y){
				return this.getHero(i);
			}
			
		}
		
		return null;
	}
	
	//������� �� ������� � ������������� ����� ��� ������� ���� ������������ ��������
	public boolean foundIn(Heroes aHero){
		for(int i=0;i<this.getSize();i++){
			if (this.getHero(i)==aHero)
					return true; 
					
			}
		
		return false;
	}
	
	//�������� ���� ��� ��� ���� aIndex, ������ ��� size ��� ������ ��� ����� ����� �� ��� ������� ���� �.�.�
	public void remove(int aIndex){
		for(int i=aIndex;i<size-1;i++){
			
			aHeroesCatalog[aIndex]=aHeroesCatalog[aIndex+1];
			aIndex++;
		}
		this.size--;	
	}
	
	//��������� ���� ����� �� ���� �� Initiative ����
	public void SelectionSort(){
		int k;
		Heroes temp;
		
		
		for (int i=0; i<size; i++){
			k=i;
			for (int j = i+1; j < size; j++)
				if (this.getHero(j).getInitiative()>this.getHero(k).getInitiative()) 
					k=j;
			temp = this.getHero(i);
			this.addHero(i, this.getHero(k));
			this.addHero(k, temp);
			}
		}
	
	//��������� ���� ���� �� ���� ��� ������ ���
	public  Heroes checkForHeroWhithIcon(ImageIcon aIcon){
		for(int i=0;i<size;i++){
			if(aIcon==this.getHero(i).getMyIcon())
				return this.getHero(i);
	
		}
		return null;
			
	}
	
	//��������� ��� ���� ��� ���� ��� �������, ������ ���������� -1
	public int indexOf(Heroes aHero){
		for(int i=0;i<this.getSize();i++){
			
			if (this.getHero(i)==aHero){
				
				return i; 
				
			}
		}
		return -1;
	}
	
}
