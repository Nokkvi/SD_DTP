package interfaces;
import classes.*;

public interface I_RatingList {
	
	//n�r � ratings fyrir �kv. daytrip
	public Rating[] pullRating(DayTrip d);
	
	public void removeRating(Rating r);

}
