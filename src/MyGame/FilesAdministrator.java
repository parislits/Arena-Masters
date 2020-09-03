package MyGame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FilesAdministrator {
	
	public static void writeHeroesToFile(HeroesCatalog aHeroCat) {
		//Εγγραφή όλων των ηρώων του παιχνιδιού σε αρχείο
		try
		{
		 File f = new File("Heroes.ser");
		 FileOutputStream fouts = new FileOutputStream(f);
		 ObjectOutputStream douts = new ObjectOutputStream(fouts);
		 douts.writeObject(aHeroCat);
		 
		 douts.close();
		}
		catch(IOException e)
		{
		 
		}

	}
	public static HeroesCatalog readsHeroesOfFile(){
		//Ανάγνωση των ηρώων από το αρχείο και καταχώρησή τους στον κεντρικό κατάλογο των ηρώων
		HeroesCatalog aHeroesCatalog;
		FileInputStream fileIn1;
		try {
			fileIn1 = new FileInputStream("Heroes.ser");
			ObjectInputStream in=new ObjectInputStream(fileIn1);
			
			aHeroesCatalog = (HeroesCatalog)in.readObject();
			in.close();
			fileIn1.close();
			return aHeroesCatalog;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	public static void writeUserToFile(UserCatalog aUserCatalog) {
		//Εγγραφή όλων των χρηστών του παιχνιδιού που έχουν δημιουργηθεί, σε αρχείο
		try
		{
			System.out.println(aUserCatalog.getUser(1).getName());
		 File f = new File("User.ser");
		 FileOutputStream fouts = new FileOutputStream(f);
		 ObjectOutputStream douts = new ObjectOutputStream(fouts);
		 douts.writeObject(aUserCatalog);
		 
		 douts.close();
		}
		catch(IOException e)
		{
		 System.out.println("lathos");
		}

	}
	public static UserCatalog readsUsersOfFile(){
		//Ανάγνωση όλων των χρηστών του παιχνιδιού που έχουν δημιουργηθεί, σε αρχείο και καταχώρησή τους στον κεντρικό κατάλογο των χρηστών
		UserCatalog aUserCatalog;
		FileInputStream fileIn1;
		try {
			fileIn1 = new FileInputStream("User.ser");
			ObjectInputStream in=new ObjectInputStream(fileIn1);
			
			aUserCatalog = (UserCatalog)in.readObject();
			in.close();
			fileIn1.close();
			return aUserCatalog;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}

}
