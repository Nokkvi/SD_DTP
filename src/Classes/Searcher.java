package Classes;

import java.util.Date;
import interfaces.*;

public class Searcher implements I_Searcher{
	private DayTrip[] temp;
	private IndivDayTrip[] indivTemp;
	private DayTripList trips;
	private IndivDayTripList indivTrips;
//	private I_Info output;
	
	public Searcher(){
		temp = new DayTrip[20];
		indivTemp = new IndivDayTrip[20];
		trips = new DayTripList();
		indivTrips = new IndivDayTripList();
	}
	
	//returns all IndivDayTrips that take place after pre and before post
	public IndivDayTrip[] searchByTime(Date pre, Date post){
		IndivDayTrip[] a = null;
		return a;
	}
	
	//returns all IndivDayTrips that have seatsAvailable equal to or exceeding size
	public Info[] searchBySize(int size){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip(size);
		Info[] output = new Info[a.length];
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			output[i].setStartTime()
		}
		return a;
	}
	
	//returns all IndivDayTrips that have Hotel as picup location
	public IndivDayTrip[] searchByPickup(Hotel hotel){
		IndivDayTrip[] a = null;
		return a;
	}
	
	//returns all DayTrips that have loc as a location
	public DayTrip[] searchByLoc(String loc){
		DayTrip[] a = null;
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
	
	public DayTrip[] getAll(){
		return null;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Þetta er Searcher Klasinn");

	}

}
