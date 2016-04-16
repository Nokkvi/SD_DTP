package classes;
import metaSearchEngine.program.*;
public class BookingOutput {
	
	private DaytripAbstract tripinfo;
	private User usr;
	private int seats;
	
	//Constructor
	//Use:	BookingOutput b = new BookingOutput(t, u);
	//Pre:	t is a DaytripAbstract object. u is a User object
	//Posr:	b is a new BookingOutput object
	public BookingOutput(DaytripAbstract t, User u, int s){
		this.tripinfo = t;
		this.usr = u;
		this.seats = s;
	}
	
	//Use:	User u = b.getUser();
	//Pre:	b is a BookingOutput object
	//Post:	u is the User object from b
	public User getUser(){
		return this.usr;
	}
	
	//Use:	DaytripExtend d = b.getTripInfo();
	//Pre:	b is a BookingOutput object
	//Post:	d is the DaytripAbstract object from b
	public DaytripAbstract getTripInfo(){
		return this.tripinfo;
	}
	
	//Use:	int s = b.getSeats();
	//Pre:	b is a BookingOutput object
	//Post:	s is a positive integer, represents seats booked.
	public int getSeats(){
		return this.seats;
	}
}
