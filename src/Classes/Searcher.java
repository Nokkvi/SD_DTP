package classes;

import java.util.Date;
import interfaces.*;
import mockObjects.M_IndivDayTripList;

public class Searcher implements I_Searcher{
	private DayTrip[] temp;
	private IndivDayTrip[] indivTemp;
	private DayTripList trips;
	private I_IndivDayTripList indivTrips;
	//private Info output;

	public Searcher(I_IndivDayTripList i){
		this.temp = new DayTrip[20];
		this.indivTemp = new IndivDayTrip[20];
		this.trips = new DayTripList();
		this.indivTrips = i;
	}

	//returns all IndivDayTrips that take place after pre and before post
	public Info[] searchByTime(Date pre, Date post){
		Info[] a = null;
		return a;
	}

	//returns all IndivDayTrips that have seatsAvailable equal to or exceeding size
	public Info[] searchBySize(int size){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		Info[] output = new Info[a.length];
		int k = 0;
		for(int i = 0; i < a.length; i++){
			if(size <= a[i].getNumSeatsAvail()){
				DayTrip parent = a[i].getParent();
				Info temp = new Info();
				temp.setIndivId(a[i].getId());
				temp.setName(parent.getName());
				temp.setStartTime(a[i].getStartTime());
				temp.setEndTime(a[i].getEndTime());
				temp.setLocation(parent.getRegion());
				temp.setPrice(parent.getPrice());
				temp.setNumSeatsAvail(a[i].getNumSeatsAvail());
				temp.setCategory(parent.getCategory());
				output[k] = temp;
				k++;
			}
		}
		Info[] trueOut = new Info[k];
		for(int p = 0;p < k;p++){
			trueOut[p] = output[p];
		}
		return trueOut;
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
