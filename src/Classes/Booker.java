package classes;
import interfaces.*;

public class Booker implements I_Booker{

	public static void main(String[] args) {
		System.out.println("�etta er Booker klasinn");

	}

	@Override
	public BookingInfo createBooking(User u, IndivDayTrip d, int seats) {
		BookInfoList b = new BookInfoList();
		//TODO Villume�h�ndlun re. of f� s�ti
		BookingInfo book = new BookingInfo(u, d, seats);
		b.addBooking(book);
		
		return book;
	}

}
