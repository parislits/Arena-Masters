package MyGame;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;


public class UserCatalog implements Serializable{
	
	


	private    ArrayList<User> allUser=new ArrayList<>(); 
	
	

	//private int size;
	public  UserCatalog(){
		allUser = new ArrayList<User>();
		//size=0;
	}
	
	

	public  User getUser(int i){
			return allUser.get(i);	
	}
	public   int getSize(){
		return allUser.size();
	}
	
	public  ArrayList<User> getAllUser(){
		return allUser;
	}
	

	public   void add(User aUser) {
		// TODO Auto-generated method stub
		allUser.add(aUser);
		//++;
	}
	
	public int indexOf(User aUser){
		for (int i=0;i<getSize();i++){
			if(aUser.getName().equals(getUser(i).getName()))
				return i;
		}
		return -1;
			
	}
	
	public User searchUserWithData(String Name,String password){

		/*Ανατρέχει τον υπάρχοντα κατάλογο με τους Users και ελέγχει αν υπάρχει σε αυτόν χρήστης με τα στοιχεία
		 * που δεχεται*/
		for(int i=0;i<getSize();i++) {
			User u= getUser(i);
			String aName =u.getName();
			String aPassword =u.getPassword();

			if(Name.equals(aName) && password.equals(aPassword)){
				return u;
			}
		}	
		return null;
	}
	
	public boolean searchUserWithName(String aName){
		
		/*Ανατρέχει τον υπάρχοντα κατάλογο με τους Users και ελέγχει αν υπάρχει σε αυτόν χρήστης με τo συγκεκριμένο όνομα
		 * που δεχεται*/
		for(int i=0;i<getSize();i++){

			if(aName.equals(getUser(i).getName()))
				return true;
		}
		
		return false;
	}
	
	
	
	
	

}
