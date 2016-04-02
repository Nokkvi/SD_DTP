package classes;
public class BookingInfo {
	private User user;
	private IndivDayTrip trip;
	private int seats;
	
	public BookingInfo(User u, IndivDayTrip t, int s){
		this.user = u;
		this.trip = t;
		this.seats = s;
	}
	
	public static void main(String[] args) {
		System.out.println("�etta er BookingInfo Klasinn");

	}

}
