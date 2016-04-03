package classes;

import java.util.Date;

public class IndivDayTrip {
	private int id;
	private Date startTime;
	private Date endTime;
	private int numSeatsAvailable;
	private DayTrip parent;
	
	public IndivDayTrip(int id, Date ST, Date ET, int nSA, DayTrip p){
		this.id = id;
		this.startTime = ST;
		this.endTime = ET;		
		this.numSeatsAvailable = nSA;
		this.parent = p;

	}
	
	public int getId(){
		return this.id;
	}
	
	public DayTrip getParent(){
		return this.parent;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�etta er IndivDayTrip Klasinn");
	}
	
	public Date getStartTime(){
		return this.startTime;
	}
	
	public int getNumSeatsAvail(){
		return this.numSeatsAvailable;
	}
	
	public Date getEndTime(){
		return this.endTime;
	}

}
