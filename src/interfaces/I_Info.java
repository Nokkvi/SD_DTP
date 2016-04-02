package interfaces;
import java.util.Date;

public interface I_Info {
	public Date getStartTime();
	public Date getEndTime();
	public String getLocation();
	public int getPrice();
	public int getNumSeatsAvail();
	public String getCategory();
	
	public void setStartTime(Date x);
	public void setEndTime(Date x);
	public void setLocation(String x);
	public void setPrice(int x);
	public void setNumSeatsAvail(int x);
	public void setCategory(String x);
}
