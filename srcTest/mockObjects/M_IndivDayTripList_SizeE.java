package mockObjects;
import java.util.Date;

import classes.*;
import interfaces.*;
//A mock object that provides a test for Searcher.searchBySize() with no acceptable results.
//Intended functionality of IndivDayTripList is to create IndivDayTrip objects for each individual Day Trip for the 
//Searcher to sift through. This Mock object creates a few pre-determined IndivDayTrips to test the functionality of the
//Searcher
public class M_IndivDayTripList_SizeE implements I_IndivDayTripList{

	@Override
	//Supposed to add an IndivDayTrip to the database. Not implemented for this test.
	public void addIndivDayTrip(IndivDayTrip d) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	//Supposed to create IndivDayTrip objects for each individual day trips. Creates a few objects with variable 
	//numSeatsLeft to test Searcher.searchBySize, none of which will have sufficient seats available.
	public IndivDayTrip[] pullIndivDayTrip() {
		
		//A mock array of unimplemented Hotels
		Hotel hothells[] = new Hotel[3];
		for(int i = 0; i < 3; i++){
			hothells[i] = new Hotel();
		}
		
		//DayTrip objects to use as parents
		DayTrip dTrip1 = new DayTrip("Rafting in Iceland", "Rafting", "IceRaft", hothells, "Spraenutorg 18", "NorduogNidur", 123456);
		DayTrip dTrip2 = new DayTrip("IceCercize", "Jazzecize", "jazzklubburinn", hothells, "djassbunga 47", "UtIRassgati", 696969);
		DayTrip dTrip3 = new DayTrip("Galactic Circle", "Star Trippin'", "Icpace", hothells, "Stjörnutorg", "Kringlan", 1000000000);
		DayTrip dTrip4 = new DayTrip("Icelandic Solitary", "Convict Trip", "Awkward Iceland", hothells, "Littla Hraun", "Eyrarbakki", 2);
		
		//An array of IndivDayTrips to return to the Searcher.
		IndivDayTrip[] trips = new IndivDayTrip[16];
		trips[0] = new IndivDayTrip(0,new Date(116, 6, 12, 16, 0), new Date(116, 6, 12, 18, 30), 8, dTrip1);
		trips[1] = new IndivDayTrip(1,new Date(116, 6, 15, 16, 0), new Date(116, 6, 15, 18, 30), 8, dTrip1);
		trips[2] = new IndivDayTrip(2,new Date(116, 8, 3, 12, 0), new Date(116, 8, 4, 15, 0), 8, dTrip2);
		trips[3] = new IndivDayTrip(3,new Date(116, 8, 10, 12, 0), new Date(116, 8, 11, 15, 0), 8, dTrip2);
		trips[4] = new IndivDayTrip(4,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[5] = new IndivDayTrip(5,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[6] = new IndivDayTrip(6,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[7] = new IndivDayTrip(7,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[8] = new IndivDayTrip(8,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[9] = new IndivDayTrip(9,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[10] = new IndivDayTrip(10,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[11] = new IndivDayTrip(11,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[12] = new IndivDayTrip(12,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[13] = new IndivDayTrip(13,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 8, dTrip2);
		trips[14] = new IndivDayTrip(14,new Date(116, 8, 17, 12, 0), new Date(2016, 8, 18, 15, 0), 8, dTrip3);
		trips[15] = new IndivDayTrip(15,new Date(116, 8, 17, 12, 0), new Date(116, 8, 18, 15, 0), 1, dTrip4);
		
		
		return trips;
	}

	@Override
	//Supposed to remove an IndivDayTrip from the database. Not implemented for this test.
	public void removeIndivDayTrip(IndivDayTrip d) {
		// TODO Auto-generated method stub
		
	}
	
}
