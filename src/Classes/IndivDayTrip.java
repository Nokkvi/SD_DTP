package classes;

import java.util.Date;

public class IndivDayTrip {
	private Date date;
	private int numSeatsAvailible;
	private DayTrip parent;
	
	public IndivDayTrip(Date d, int nSA, DayTrip p){
		this.date = d;
		this.numSeatsAvailible = nSA;
		this.parent = p;
	}
	
	public DayTrip getParent(){
		return this.parent;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�etta er IndivDayTrip Klasinn");
	}

}
