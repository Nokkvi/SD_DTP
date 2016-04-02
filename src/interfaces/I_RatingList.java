package interfaces;
import classes.*;

public interface I_RatingList {
	public void addRating(Rating r);
	
	//nær í ratings fyrir ákv. daytrip
	public Rating[] pullRating(DayTrip d);
	public void removeRating(Rating r);
}
