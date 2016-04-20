package tests;
import java.util.*;
import metaSearchEngine.program.*;
import classes.*;

public class Testing {

	public static void main(String[] args){
		//Database.connectToDatabase();
		int JonID = 989898;
		String JonStr = Integer.toString(JonID);
	    UserList.addUser(JonStr, "Saga Hotel", "Reykjavik", "Jon Aron", "jona@hi.is");
	    System.out.println("User added");
	    DayTripSearchCriteria c = new DayTripSearchCriteria();
	   // c.setName("super jeep");
	    c.setCategory("adventure");
	   // c.setNumParticipants(5);
	    ArrayList<DaytripAbstract> x = DaytripSearcher.search(c);
	    System.out.println("Search Performed");
	    DaytripAbstract[] xy = new DaytripAbstract[x.size()];
	    x.toArray(xy);
	    User u = UserList.pullUser(JonStr);
	    System.out.println("User pulled");
	    System.out.println(u.getName());
	    for(int g = 0; g < xy.length; g++){
	    	System.out.println(xy[g].getName());
	    }
	    DaytripBooker.bookTrip(u, xy[0], 5);
	    System.out.println("Trip Booked");
	    //Database.closeDatabase();
	}
}
