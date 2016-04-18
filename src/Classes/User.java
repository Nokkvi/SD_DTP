package classes;
import interfaces.UserClass;

public class User extends UserClass{
	private String hotel;
	private String town;
	
	public User(String ID, String h, String s, String n, String mail){
		hotel = h;
		town = s;
		username = n;
		email = mail;
		id = ID;
	}
	
	public static void main(String[] args) {
		System.out.println("Þetta er User Klasinn");

	}

    @Override
    public void setUserName(String newUserName) {
        this.username = newUserName;    
    }

    @Override
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    
    public String getHotel(){
    	return this.hotel;
    }
    
    public String getTown(){
    	return this.town;
    }
    
    public String getId(){
    	return this.id;
    }
	
    public String getName(){
    	return this.username;
    }
    
    public String getEmail(){
    	return this.email;
    }
}
