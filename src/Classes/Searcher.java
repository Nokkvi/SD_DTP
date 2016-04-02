package classes;

import java.util.Date;
import interfaces.*;

public class Searcher implements I_Searcher{
	private DayTrip[] temp;
	private IndivDayTrip[] indivTemp;
	private DayTripList trips;
	private IndivDayTripList indivTrips;
	//private Info output;
	
	public Searcher(){
		temp = new DayTrip[20];
		indivTemp = new IndivDayTrip[20];
		trips = new DayTripList();
		indivTrips = new IndivDayTripList();
	}
	
	//returns all IndivDayTrips that take place after pre and before post
	public Info[] searchByTime(Date pre, Date post){
		Info[] a = null;
		return a;
	}
	
	//returns all IndivDayTrips that have seatsAvailable equal to or exceeding size
	public Info[] searchBySize(int size){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip(size);
		Info[] output = new Info[a.length];
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			output[i].setStartTime(a[i].getStartTime());
			output[i].setEndTime(a[i].getEndTime());
			output[i].setLocation(parent.getRegion());
			output[i].setPrice(parent.getPrice());
			output[i].setNumSeatsAvail(a[i].getNumSeatsAvail());
			output[i].setCategory(parent.getCategory());		
		}
		return output;
	}
	
	//returns all IndivDayTrips that have Hotel as picup location
	public Info[] searchByPickup(Hotel hotel){
		Info[] a = null;
		return a;
	}
	
	//returns all DayTrips that have loc as a location
	public Info[] searchByLoc(String loc){
		Info[] a = null;
		return a;
	}
	
	//returns all DayTrips that contain 
	public DayTrip[] searchByKeywords(String[] keywords){
		DayTrip[] a = null;
		return a;
	}
	
	public void sort(char param){
		
	}
	
	public DayTrip[] suggestions(DayTrip trip){
		DayTrip[] a = null;
		return a;
	}
	
	public DayTrip selectTrip(int select){
		return this.temp[select];
	}
	
	public Info[] getAll(){
		return null;
	}
	
	public DayTrip[] selectTrip(DayTrip d){
		DayTrip[] a = null;
		return a;
	};
	
	
	public static void main(String[] args) {
		System.out.println("�etta er Searcher Klasinn");

	}

}
