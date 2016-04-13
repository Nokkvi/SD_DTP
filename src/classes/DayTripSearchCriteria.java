package classes;

public class DayTripSearchCriteria {
	private String name;
	private String location;
	private String startTime;
	private String endTime;
	private int[] priceRange;
	private int numParticipants;
	private String[] category;

	public String getName(){
		return this.name;
	}
	
	public String getLocation(){
		return this.location;
	}

	public String getStartTime(){
		return this.startTime;
	}
	
	public String getEndTime(){
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
