
public class IndivDayTrip {
	private String date;
	private int numSeatsAvail;
	private DayTrip parent;
	
	public DayTrip getParent(){
		return this.parent;
	}
	
	public int getSeats(){
		return this.numSeatsAvail;
	}
	
	public String getDate(){
		return this.date;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Þetta er IndivDayTrip Klasinn");
	}

}
