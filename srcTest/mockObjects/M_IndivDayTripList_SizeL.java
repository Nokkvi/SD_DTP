package mockObjects;
import java.util.Date;

import classes.*;
import interfaces.*;
//A mock object that provides a general test for Searcher.searchBySize().
//Intended functionality of IndivDayTripList is to create IndivDayTrip objects for each individual Day Trip for the 
//Searcher to sift through. This Mock object creates several pre-determined IndivDayTrips to test the functionality of the
//Searcher with a large number of IndivDayTrip objects
public class M_IndivDayTripList_SizeL implements I_IndivDayTripList{

	@Override
	//Supposed to add an IndivDayTrip to the database. Not implemented for this test.
	public void addIndivDayTrip(IndivDayTrip d) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	//Supposed to create IndivDayTrip objects for each individual day trips. Creates a few objects with variable 
	//numSeatsAvailable to test Searcher.searchBySize. A few may or may not fall within the given constraint. 
	//The last one in particular is intended to not have enough seats.
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
		IndivDayTrip[] trips = new IndivDayTrip[1000];
		for(int i = 0; i < 250; i++){
			trips[i] = new IndivDayTrip(i, new Date(116, 6, 12, 16, 0), new Date(116, 6, 12, 18, 30), 16, dTrip1);
		}
		for(int i = 250; i < 500; i++){
			trips[i] = new IndivDayTrip(i, new Date(116, 8, 3, 12, 0), new Date(116, 8, 4, 15, 0), 50, dTrip2);
		}
		for(int i = 500; i < 750; i++){
			trips[i] = new IndivDayTrip(i, new Date(116, 8, 3, 12, 0), new Date(116, 8, 4, 15, 0), 50, dTrip3);
		}
		for(int i = 750; i < 1000; i++){
			trips[i] = new IndivDayTrip(i, new Date(116, 8, 3, 12, 0), new Date(116, 8, 4, 15, 0), 1, dTrip4);
		}
		
		
		return trips;
	}

	@Override
	//Supposed to remove an IndivDayTrip from the database. Not implemented for this test.
	public void removeIndivDayTrip(IndivDayTrip d) {
		// TODO Auto-generated method stub
		
	}
	
}