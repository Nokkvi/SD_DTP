package interfaces;
import classes.*;

public interface I_BookInfoList {
	public void addBooking(BookingInfo b);
	public BookingInfo pullBooking();
	public void removeBooking(BookingInfo b);

}
