package interfaces;
import classes.*;

public interface I_RatingList {
	
	//nær í ratings fyrir ákv. daytrip
	public Rating[] pullRating(DayTrip d);
	
	public void removeRating(Rating r);

}
