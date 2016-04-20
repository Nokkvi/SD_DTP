package classes;
import java.util.Date;

public class DayTripSearchCriteria {
	private String name;
	private String location;
	private Date startTime;
	private Date endTime;
	private int[] priceRange = new int[2];
	private int numParticipants;
	private String[] category;

	public DayTripSearchCriteria(){
		name = null;
		location = null;
		startTime = null;
		endTime = null;
		priceRange[0] = -1;
		priceRange[1] = -1;
		numParticipants = -1;
		category = null;
	}
	
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
	
	public void setName(String n){
		this.name = n;
	}
}
