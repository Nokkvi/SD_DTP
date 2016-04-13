package classes;
import java.util.*;
import interfaces.*;

public class Rating implements I_Rating{

	private DayTrip parent;
	private Date dateTime;
	private int rate;
	private String comment;
	private User user;
	
	public Rating(DayTrip par, int rat, String com, User usr){
		this.parent = par;
		this.dateTime = new Date();
		this.rate = rat;
		this.comment = com;
		this.user = usr;
	}
	
	
	public static void main(String[] args) {
		System.out.println("�etta er Rating Klasinn");

	}

}
