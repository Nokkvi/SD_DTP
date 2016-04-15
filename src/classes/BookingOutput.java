package classes;

public class BookingOutput {
	
	private DaytripExtend tripinfo;
	private User usr;
	private int seats;
	
	//Constructor
	//Use:	BookingOutput b = new BookingOutput(t, u);
	//Pre:	t is a DaytripExtend object. u is a User object
	//Posr:	b is a new BookingOutput object
	public BookingOutput(DaytripExtend t, User u, int s){
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
	//Post:	d is the DaytripExtend object from b
	public DaytripExtend getTripInfo(){
		return this.tripinfo;
	}
	
	public int getSeats(){
		return this.seats;
	}
}
