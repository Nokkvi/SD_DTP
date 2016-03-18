import java.util.Date;

public class Searcher {
	private DayTrip[] trips;
	
	public Searcher(){
		trips = new DayTrip[20];
	}
	
	//returns all IndivDayTrips that take place after pre and before post
	public IndivDayTrip[] searchByTime(Date pre, Date post){
		IndivDayTrip[] a = null;
		return a;
	}
	
	//returns all IndivDayTrips that have seatsAvailable equal to or exceeding size
	public IndivDayTrip[] searchBySize(int size){
		IndivDayTrip[] a = null;
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
		return this.trips[select];
	}
	
	public DayTrip[] getAll(){
		return this.trips;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Þetta er Searcher Klasinn");

	}

}
