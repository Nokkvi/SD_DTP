package classes;

public class DaytripBooker {

	public static void bookTrip(User user, DaytripExtend tripInfo, int seats){
		BookInfoList b = new BookInfoList();
		DaytripSearcher s = new DaytripSearcher();
		int ID = tripInfo.getIndivId();
		IndivDayTrip trip = s.searchByID(ID);
		BookingInfo booking = new BookingInfo(user, trip, seats);
		b.addBooking(booking);
	}
	
	public static BookingOutput getBookingInfo(User usr){
		BookInfoList b = new BookInfoList();
		BookingInfo[] book = b.pullBooking();
		BookingInfo theBook;
		for(int i = 0; i < book.length; i++){
			String name = book[i].getUser().getName();
			
			if(name.equals(usr)){
				theBook = book[i];
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("�etta er Booker klasinn");

	}

}
