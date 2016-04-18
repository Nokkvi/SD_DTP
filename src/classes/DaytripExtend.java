package classes;
import metaSearchEngine.program.DaytripAbstract;
import java.util.Date;


public class DaytripExtend extends DaytripAbstract{
	
	private int indivId;
	private String name;
	private Date startTime;
	private Date endTime;
	private String loc;
	private int price;
	private int  numParticipantsAvail;
	private String category;
	private String[] dealerInfo;

	public DaytripExtend(Date startTime, Date endTime, String loc, int price, int numParticipants, String category, String[] dealerInfo, String tripname, int id) {
		super(startTime, endTime, loc, price, numParticipants, category, dealerInfo, tripname);
		this.indivId = id;
		this.name = tripname;
		this.price = price;
		this.startTime = startTime;
		this.endTime = endTime;
		this.loc = loc;
		this.numParticipantsAvail = numParticipants;
		this.category = category;
		this.dealerInfo = dealerInfo;
	}
	
	public void setIndivId(int x){
		this.indivId = x;
	}

	public int getIndivID(){
		return this.indivId;
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
	
	public int getNumParticipantsAvail(){
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
