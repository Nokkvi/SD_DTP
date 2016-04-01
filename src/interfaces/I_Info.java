package interfaces;

public interface I_Info {
	public String getStartTime();
	public String getEndTime();
	public String getLocation();
	public int getPrice();
	public int getNumSeatsAvail();
	public String getCategory();
	
	public void setStartTime();
	public void setEndTime();
	public void setLocation();
	public void setPrice();
	public void setNumSeatsAvail();
	public void setCategory();
}
