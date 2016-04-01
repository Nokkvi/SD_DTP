package Classes;


public class Info {
	
	private String startTime;
	private String endTime;
	private String location;
	private int price;
	private int  numSeatsAvail;
	private String category;
	
	public void setStart(String x){
		this.startTime = x;
	}
	
	public void setEnd(String x){
		this.endTime = x;
	}
	
	public void setLoc(String x){
		this.location = x;
	}
	
	public void setPrice(int x){
		this.price = x;
	}
	
	public void setSeats(int x){
		this.numSeatsAvail = x;
	}
	
	public void setCat(String x){
		this.category = x;
	}
	
	public String getStart(){
		return this.startTime;
	}
	
	public String getEnd(){
		return this.endTime;
	}
	
	public String getLoc(){
		return this.location;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getSeats(){
		return this.numSeatsAvail;
	}
	
	public String getCat(){
		return this.category;
	}
	
	public static void main(String[] args) {
		System.out.println("Þetta er Info Klasinn");

	}

}
