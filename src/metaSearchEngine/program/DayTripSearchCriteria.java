package metaSearchEngine.program;
import java.util.Date;

public class DayTripSearchCriteria {
	private String name;
	private String location;
	private Date startTime;
	private Date endTime;
	private int[] priceRange = new int[2];
	private int numParticipants;
	private String category;

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
	
	public String getCategory(){
		return this.category;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setPrice(int i, int j){
		this.priceRange[0] = i;
		this.priceRange[1] = j;
	}
	
	public void setNumParticipants(int num){
		this.numParticipants = num;
	}
	
	public void setCategory(String cat){
		this.category = cat;
	}
	
	public void setLocation(String loc){
		this.location = loc;
	}
	
	public void setStartTime(Date start){
		this.startTime = start;
	}
	
	public void setEndTime(Date end){
		this.endTime = end;
	}
}
