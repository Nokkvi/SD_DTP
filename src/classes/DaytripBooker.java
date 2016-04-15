package classes;
import java.util.*;

public class DaytripBooker {

	public static BookingOutput bookTrip(User user, List<String> dealerInfo, int price, List<String> review, DaytripExtend tripInfo, int seats){
		BookInfoList b = new BookInfoList();
		DaytripSearcher s = new DaytripSearcher();
		int ID = tripInfo.getIndivId();
		IndivDayTrip trip = s.searchByID(ID);
		BookingInfo booking = new BookingInfo(user, trip, seats);
		b.addBooking(booking);
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("�etta er Booker klasinn");

	}

}
