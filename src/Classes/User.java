package classes;
import interfaces.*;

public class User implements I_User{
	private Hotel hotel;
	private String town;
	private String name;
	
	public User(Hotel h, String s, String n){
		this.hotel = h;
		this.town = s;
		this.name = n;
	}
	
	public static void main(String[] args) {
		System.out.println("�etta er User Klasinn");

	}
	

}
