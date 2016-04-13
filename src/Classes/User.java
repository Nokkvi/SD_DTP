package classes;
import interfaces.UserClass;

public class User extends UserClass{
	private Hotel hotel;
	private String town;
	
	public User(Hotel h, String s, String n){
		hotel = h;
		town = s;
		username = n;
	}
	
	public static void main(String[] args) {
		System.out.println("Þetta er User Klasinn");

	}

    @Override
    public void setUserName(String newUserName) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setEmail(String newEmail) {
        // TODO Auto-generated method stub
        
    }
	

}
