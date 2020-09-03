package MyGame;

import java.io.Serializable;

public class User implements Comparable<User>,Serializable{
	

	private String name ;
	private String password;
	private int marks;
	
	
	public User(String aName,String aPassword){
		name = aName;
		password=aPassword;
		marks=0;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getName_Marks (){
		String aName_marks=name+": "+ marks;
		return aName_marks;
		
	}

	

	public void setMarks(int aMarks){
		this.marks=aMarks;
	}
	public int getMarks(){
		return marks;
	}
	public void print(){
		System.out.println(marks);
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		User otherUser = (User)o;
		int mark=((User)o).getMarks();
		return mark - this.marks;
	}

}
