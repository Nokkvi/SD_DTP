package tests;
import java.util.*;
import metaSearchEngine.program.*;
import classes.*;

public class Testing {

	public static void main(String[] args){
		//Database.connectToDatabase();
	    UserList.addUser("698989", "Grand Hotel", "Reykjavik", "John Doe", "doej@bull.is");
	    System.out.println("User added");
	    DayTripSearchCriteria c = new DayTripSearchCriteria();
	    c.setName("Golden");
	    ArrayList<DaytripAbstract> x = DaytripSearcher.search(c);
	    System.out.println("Search Performed");
	    DaytripAbstract[] xy = new DaytripAbstract[x.size()];
	    x.toArray(xy);
	    User u = UserList.pullUser("698989");
	    System.out.println("User pulled");
	    System.out.println(u.getName());
	    DaytripBooker.bookTrip(u, xy[3], 5);
	    System.out.println("Trip Booked");
	    
	    //Database.closeDatabase();
	}
}
