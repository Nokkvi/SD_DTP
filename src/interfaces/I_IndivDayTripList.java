package interfaces;
import classes.*;

public interface I_IndivDayTripList {
	
	public void addIndivDayTrip(IndivDayTrip d);
	
	//pull by size
	public IndivDayTrip[] pullIndivDayTrip();
	
	public void removeIndivDayTrip(IndivDayTrip d);
}
