package mockObjects;
import java.util.Date;

import classes.DayTrip;
import classes.Hotel;
import classes.IndivDayTrip;
import classes.IndivDayTripList;
import classes.RatingList;
import interfaces.*;

public class M_IndivDayTripList implements I_IndivDayTripList{

	@Override
	public void addIndivDayTrip(IndivDayTrip d) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public IndivDayTrip[] pullIndivDayTrip() {
		//IndivDayTrip(Date ST, Date ET, int nSA, DayTrip p)
		/*DayTrip(String name,
			String category,
			String comp,
			Hotel[] PickupLocation,
			String address,
			String region,
			int pr)*/
		
		Hotel hothells[] = new Hotel[3];
		for(int i = 0; i < 3; i++){
			hothells[i] = new Hotel();
		}
		
		
		DayTrip dTrip1 = new DayTrip("Rafting in Iceland", "Rafting", "IceRaft", hothells, "Spraenutorg 18", "NorduogNidur", 123456);
		DayTrip dTrip2 = new DayTrip("IceCercize", "Jazzecize", "jazzklubburinn", hothells, "djassbunga 47", "UtIRassgati", 696969);
		
		IndivDayTrip[] trips = new IndivDayTrip[14];
		trips[0] = new IndivDayTrip(0,new Date(116, 6, 12, 16, 0), new Date(116, 6, 12, 18, 30), 16, dTrip1);
		trips[1] = new IndivDayTrip(1,new Date(116, 6, 15, 16, 0), new Date(116, 6, 15, 18, 30), 23, dTrip1);
		trips[2] = new IndivDayTrip(2,new Date(116, 8, 3, 12, 0), new Date(116, 8, 4, 15, 0), 50, dTrip2);
		trips[3] = new IndivDayTrip(3,new Date(116, 8, 10, 12, 0), new Date(116, 8, 11, 15, 0), 50, dTrip2);
		trips[4] = new IndivDayTrip(4,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[5] = new IndivDayTrip(5,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[6] = new IndivDayTrip(6,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[7] = new IndivDayTrip(7,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[8] = new IndivDayTrip(8,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[9] = new IndivDayTrip(9,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[10] = new IndivDayTrip(10,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[11] = new IndivDayTrip(11,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[12] = new IndivDayTrip(12,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		trips[13] = new IndivDayTrip(13,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 50, dTrip2);
		
		return trips;
	}

	@Override
	public void removeIndivDayTrip(IndivDayTrip d) {
		// TODO Auto-generated method stub
		
	}
	
}
