package interfaces;
import classes.*;

public interface I_DayTripList {
	public void addDayTrip(DayTrip d);
	public DayTrip[] pullDayTrip();
	public void removeDayTrip(DayTrip d);
}
