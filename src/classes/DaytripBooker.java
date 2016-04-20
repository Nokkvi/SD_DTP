package classes;
import java.util.*;
import metaSearchEngine.program.*;

public class DaytripBooker {
	
	//Use:	bookTrip(u, t, s)
	//Pre:	u is a User object, t is a DaytripAbstract object, s is a positive integer
	//Post:	Adds a new booking into the booking database.
	public static void bookTrip(User user, DaytripAbstract tripInfo, int seats){
		int ID = tripInfo.getIndivID();
		IndivDayTrip trip = DaytripSearcher.searchByID(ID);
		if(trip.getNumSeatsAvail() >= seats){
			BookingInfo booking = new BookingInfo(user, trip, seats);
			BookInfoList.addBooking(booking);
		}else{
			System.out.println("Not enough seats.");
		}
		
	}
	
	//Use:	BookingOutput[] b = getBookingInfo(u);
	//Pre:	u is a User object.
	//Post:	returns an array of BookingOutput objects representing
	//		all bookings made by that user.
	public static BookingOutput[] getBookingInfo(User usr){
		BookInfoList b = new BookInfoList();
		BookingInfo[] book = b.pullBooking();
		int k = 0;
		Vector<BookingInfo> books = new Vector<BookingInfo>();
		String compId = usr.getId();
		for(int i = 0; i < book.length; i++){
			String id = book[i].getUser().getId();
			if(id.equals(compId)){
				books.add(book[i]);
				k++;
			}
		}
		BookingInfo[] truIp = new BookingInfo[k];
		books.toArray(truIp);
		BookingOutput[] ouP = new BookingOutput[k];
		for(int j = 0; j < k; j++){
			IndivDayTrip d = truIp[j].getTrip();
			DaytripAbstract I = DaytripSearcher.createInfo(d);
			User u = truIp[j].getUser();
			int s = truIp[j].getSeats();
			ouP[j] = new BookingOutput(I, u, s);
		}
		return ouP;
	}
	
	public static void main(String[] args) {
		System.out.println("�etta er Booker klasinn");

	}

}
