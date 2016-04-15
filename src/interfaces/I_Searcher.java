package interfaces;
import classes.*;
import java.util.Date;

public interface I_Searcher {
	public DaytripExtend[] searchByTime(Date pre, Date Post);
	public DaytripExtend[] searchBySize(int s);
	public DaytripExtend[] searchByPickup(String h);
	public DaytripExtend[] searchByLoc(String s);
	public void sort(char c);
	public DayTrip[] suggestions(DayTrip d);
	public DayTrip[] selectTrip(DayTrip d);
	public DaytripExtend[] getAll();	
}
