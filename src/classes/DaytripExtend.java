package classes;
import metaSearchEngine.program.DaytripAbstract;
import interfaces.*;
import java.util.Date;


public class DaytripExtend extends DaytripAbstract{
	
	private int IndivId;
	private String name;
	private Date startTime;
	private Date endTime;
	private String loc;
	private int price;
	private int  numParticipantsAvail;
	private String category;
	private String[] dealerInfo;

	public DaytripExtend(Date startTime, Date endTime, String loc, int price, int numParticipants, String category, String[] dealerInfo /*, ...*/) {
		super(startTime, endTime, loc, price, numParticipants, category, dealerInfo);
		// ...
	}
	
	public void setIndivId(int x){
		this.IndivId = x;
	}
	
	public void setName(String x){
		this.name = x;
	}
	
	public void setStartTime(Date x){
		this.startTime = x;
	}
	
	public void setEndTime(Date x){
		this.endTime = x;
	}
	
	public void setLocation(String x){
		this.loc = x;
	}
	
	public void setPrice(int x){
		this.price = x;
	}
	
	public void setNumSeatsAvail(int x){
		this.numParticipantsAvail = x;
	}
	
	public void setCategory(String x){
		this.category = x;
	}
	
	public void setDealerInfo(String n, String p, String e){
		String[] I = new String[3];
		I[0] = n;
		I[1] = p;
		I[2] = e;
		this.dealerInfo = I;
	}
	
	public int getIndivId(){
		return this.IndivId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Date getStartTime(){
		return this.startTime;
	}
	
	public Date getEndTime(){
		return this.endTime;
	}
	
	public String getLocation(){
		return this.loc;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getNumSeatsAvail(){
		return this.numParticipantsAvail;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public String[] getDealerInfo(){
		return this.dealerInfo;
	}
	
	public static void main(String[] args) {
		System.out.println("");

	}

}
