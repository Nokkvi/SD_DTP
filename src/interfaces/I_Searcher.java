package interfaces;
import classes.*;
import java.util.Date;

public interface I_Searcher {
	public Info[] searchByTime(Date pre, Date Post);
	public Info[] searchBySize(int s);
	public Info[] searchByPickup(String h);
	public Info[] searchByLoc(String s);
	public void sort(char c);
	public DayTrip[] suggestions(DayTrip d);
	public DayTrip[] selectTrip(DayTrip d);
	public Info[] getAll();	
}
