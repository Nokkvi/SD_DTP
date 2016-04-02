package classes;

import java.util.Date;

public class IndivDayTrip {
	private Date startTime;
	private Date endTime;
	private int numSeatsAvailable;
	private DayTrip parent;
	
	public IndivDayTrip(Date ST, Date ET, int nSA, DayTrip p){
		this.startTime = ST;
		this.endTime = ET;		
		this.numSeatsAvailable = nSA;
		this.parent = p;

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
