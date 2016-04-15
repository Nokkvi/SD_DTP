package classes;
import java.util.*;

public class DaytripBooker {
	
	//Use:	bookTrip(u, t, s)
	//Pre:	u is a User object, t is a DaytripExtend object, s is a positive integer
	//Post:	Adds a new booking into the booking database.
	public static void bookTrip(User user, DaytripExtend tripInfo, int seats){
		BookInfoList b = new BookInfoList();
		DaytripSearcher s = new DaytripSearcher();
		int ID = tripInfo.getIndivId();
		IndivDayTrip trip = s.searchByID(ID);
		BookingInfo booking = new BookingInfo(user, trip, seats);
		b.addBooking(booking);
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
			DaytripExtend I = DaytripSearcher.createInfo(d);
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
