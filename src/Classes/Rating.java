package classes;
import java.util.*;

public class Rating{

	private DayTrip trip;
	private Date dateTime;
	private int rate;
	private String comment;
	private User user;
	
	public Rating(DayTrip par, int rat, String com, User usr){
		this.trip = par;
		this.dateTime = new Date();
		this.rate = rat;
		this.comment = com;
		this.user = usr;
	}
	
	public DayTrip getTrip(){
		return this.trip;
	}
	
	public Date getDate(){
		return this.dateTime;
	}
	
	public int getRate(){
		return this.rate;
	}
	
	public String getComment(){
		return this.comment;
	}
	
	public User getUser(){
		return this.user;
	}
	
	
	public static void main(String[] args) {
		System.out.println("�etta er Rating Klasinn");

	}

}
