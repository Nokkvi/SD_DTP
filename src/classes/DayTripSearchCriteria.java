package classes;
import java.util.Date;

public class DayTripSearchCriteria {
	private String name;
	private String location;
	private Date startTime;
	private Date endTime;
	private int[] priceRange;
	private int numParticipants;
	private String[] category;

	public String getName(){
		return this.name;
	}
	
	public String getLocation(){
		return this.location;
	}

	public Date getStartTime(){
		return this.startTime;
	}
	
	public Date getEndTime(){
		return this.endTime;
	}
	
	public int[] getPriceRange(){
		return this.priceRange;
	}
	
	public int getNumParticipants(){
		return this.numParticipants;
	}
	
	public String[] getCategory(){
		return this.category;
	}
	
}
