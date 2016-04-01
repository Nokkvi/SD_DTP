package interfaces;
import Classes.*;

public interface I_IndivDayTripList {
	
	public void addIndivDayTrip(IndivDayTrip d);
	//Creates Array of IndivDayTrips for all IndivDayTrips with at least
	//s available seats
	public IndivDayTrip[] pullIndivDayTrip(int s);
	public void removeIndivDayTrip(IndivDayTrip d);
}
