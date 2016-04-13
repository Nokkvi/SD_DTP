package interfaces;
import classes.*;

public interface I_Booker {
	public BookingInfo createBooking(User u, IndivDayTrip d, int seats);
}
