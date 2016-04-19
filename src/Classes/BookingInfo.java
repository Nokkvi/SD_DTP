package classes;
import interfaces.*;

public class BookingInfo{
	private User user;
	private IndivDayTrip trip;
	private int seats;
	
	public BookingInfo(User u, IndivDayTrip t, int s){
		this.user = u;
		this.trip = t;
		this.seats = s;
	}
	
	public User getUser(){
		return this.user;
	}
	
	public IndivDayTrip getTrip(){
		return this.trip;
	}
	
	public int getSeats(){
		return this.seats;
	}
	
	public static void main(String[] args) {
		System.out.println("�etta er BookingInfo Klasinn");

	}

}
