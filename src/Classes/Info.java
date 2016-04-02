package classes;
import interfaces.*;
import java.util.Date;


public class Info implements I_Info{
	
	private Date startTime;
	private Date endTime;
	private String location;
	private int price;
	private int  numSeatsAvail;
	private String category;
	
	public void setStartTime(Date x){
		this.startTime = x;
	}
	
	public void setEndTime(Date x){
		this.endTime = x;
	}
	
	public void setLocation(String x){
		this.location = x;
	}
	
	public void setPrice(int x){
		this.price = x;
	}
	
	public void setNumSeatsAvail(int x){
		this.numSeatsAvail = x;
	}
	
	public void setCategory(String x){
		this.category = x;
	}
	
	public Date getStartTime(){
		return this.startTime;
	}
	
	public Date getEndTime(){
		return this.endTime;
	}
	
	public String getLocation(){
		return this.location;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getNumSeatsAvail(){
		return this.numSeatsAvail;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public static void main(String[] args) {
		System.out.println("Þetta er Info Klasinn");

	}

}
