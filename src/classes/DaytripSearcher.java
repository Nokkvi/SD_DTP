package classes;

import java.util.*;
import interfaces.*;

public class DaytripSearcher implements I_Searcher{
	
	private I_IndivDayTripList indivTrips;

	//Use:	DaytripSearcher d = new DaytripSearcher();
	//Pre:	N/A
	//Post:	constructs a new DaytripSearcher
	public DaytripSearcher(){
		this.indivTrips = new IndivDayTripList();
	}
	
	/*	MAIN SEARCH_BY_CRITERIA FUNCTION
	 * 	returns day trip information based on input from a given DayTripSearchCriteria object.	 
	 * 	The DayTripSearchCriteria object contains the following criteria:
	 * 	String name:			Name of parent daytrip, if null search by name will not be perfomed
	 * 	String location:		Location of parent daytrip, if null search by location will not be perfomed
	 * 	Date startTime:			Minimum start time of daytrip, null for unbounded
	 * 	Date endTime:			Maximum end time of daytrip, later than startTime, null for unbounded
	 *							If both startTime and endTime are null, search by date will not be performed
	 * 	int[] priceRange:		The range within which the price of the daytrip ust fall,
	 * 							priceRange[0] for lower bound, priceRange[1] for upper bound
	 *							priceRange[1] should be greater than priceRange[0]. If either is negative, search
	 *							is unbound in that direction. If both are negative search will not be performed 
	 *							based on price.
	 * 	int numParticipants:	The minimum seats left of daytrip, if negative search by size will not be perfomed
	 * 	String[] Category:		Categories of parent daytrip, if null search by category will not be perfomed
	 *
	 *	Use:	DaytripExtend d = DaytripSearcher.search(c)
	 *	Pre:	c is a DayTripSearchCriteria object as described above
	 *	Post:	d contains information extracted from IndivDayTrips matching the criteria in c.
	 *
	*/
	public DaytripExtend[] search(DayTripSearchCriteria crit){
		IndivDayTrip[] output = indivTrips.pullIndivDayTrip();
		
		String tName = crit.getName();
		String tLoc = crit.getLocation();
		Date tSTime = crit.getStartTime();
		Date tETime = crit.getEndTime();
		int[] tPRange = crit.getPriceRange();
		int tSeats = crit.getNumParticipants();
		String[] tCat = crit.getCategory();
		
		if(tName != null)	output = this.searchByName(tName, output);
		if(tLoc != null)	output = this.searchByLoc(tLoc, output);
		if(tSTime != null && tETime != null){
			output = this.searchByTime(tSTime, tETime, output);
		}
		if(tPRange != null) output = this.searchByPrice(tPRange, output);
		if(tSeats != 0)	output = this.searchBySize(tSeats, output);
		if(tCat != null)	output = this.searchByKeywords(tCat, output);
		
		return createInfo(output);
	}
	
	//PRIVATE SEARCH HELPER FUNCTIONS
	
	
	//Use:	IndivDayTrip[] output = searchByName(n, in);
	//Pre:	n is a string representing name of desired daytrip
	//		in is the IndivDayTrip array that the function searches through
	//Post:	output is an array of IndivDayTrips in in whose parent's name contain
	//		string n.
	private IndivDayTrip[] searchByName(String name, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String n = parent.getName();
			if(n.toLowerCase().contains(name.toLowerCase())){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	private IndivDayTrip[] searchByLoc(String loc, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String l = parent.getName();
			if(l.equals(loc)){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	private IndivDayTrip[] searchByTime(Date startTime, Date endTime, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			Date tS = input[i].getStartTime();
			Date tE = input[i].getEndTime();
			if( (startTime.compareTo(tS)<0 || startTime == null) && 
				(endTime.compareTo(tE)>0 || endTime == null) )
			{
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	private IndivDayTrip[] searchByPrice(int price[], IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			int money = parent.getPrice();
			if(price[0] >= money && price[1] <= money){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);		
	}
	
	private IndivDayTrip[] searchBySize(int size, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			int tSize = input[i].getNumSeatsAvail();
			if(tSize >= size){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);	
	}
	
	private IndivDayTrip[] searchByKeywords(String[] keywords, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String[] kWords = parent.getKeywords();
			if(this.matchOne(keywords, kWords)){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);			
	}
	
	private IndivDayTrip[] searchByCompany(String comp, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String[] cArr = parent.getCompany();
			String c = cArr[0];
			if(c.toLowerCase().contains(comp.toLowerCase())){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	private IndivDayTrip[] searchInDesc(String desc, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			if(parent.getDesc().toLowerCase().contains(desc.toLowerCase())){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	private IndivDayTrip[] searchByPickup(String hotel, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String[] h = parent.getPickups();
			String[] th = {hotel};
			if(matchOne(th, h)){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	protected IndivDayTrip searchByID(int ID){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		IndivDayTrip trip = null;
		for(int i = 0; i < a.length; i++){
			if(a[i].getId() == ID){
				trip = a[i];
			}
		}
		return trip;
		
	}
	
	
	
	//PUBLIC SINGLE CRITERIA SEARCH FUNCTIONS
	
	//returns all IndivDayTrips by their parents name
	//Use:	DaytripExtend[] I = searchByName(n);
	//Pre:	n is a string
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents name contains n.
	public DaytripExtend[] searchByName(String name){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByName(name, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips by their parents location
	//Use:	DaytripExtend[] I = searchByLoc(l);
	//Pre:	l is a string
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents location is l
	public DaytripExtend[] searchByLoc(String loc){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByLoc(loc, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips within a certain timeframe
	//Use:	DaytripExtend[] I = searchByTime(pre, post);
	//Pre:	pre and post are Date objects. one, but not both
	//		can have the value null. post contains a date later
	//		than pre.
	//Post:	I contains information extracted from all IndivDayTrips
	//		within the timeframe between pre and post (inclusive)
	public DaytripExtend[] searchByTime(Date pre, Date post){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByTime(pre, post, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips with a parent within a certain pricerange
	//Use:	DaytripExtend[] I = searchByPrice(p);
	//Pre:	p is a two value int array. p[1] > p[0].
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents price lies within the two values in p (inclusive).
	public DaytripExtend[] searchByPrice(int[] price){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByPrice(price, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that have a certain number of seats available
	//Use:	DaytripExtend[] I = searchBySize(int s);
	//Pre:	s is an integer. s > 0
	//Post:	I contains information extracted from all IndivDayTrips
	//		with a number of available seats greater or equal to s.
	public DaytripExtend[] searchBySize(int size){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchBySize(size, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips whose parents have at least one keyword in common with a giver array
	//Use:	DaytripExtend[] I = searchByKeywords(k);
	//Pre:	k is a String array.
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parent has at least one keyword string in common with k
	public DaytripExtend[] searchByKeywords(String[] keywords){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByKeywords(keywords, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips from a specific company
	//Not used in main search function
	//Use:	DaytripExtend[] I = searchByCompany(c);
	//Pre:	c is a String
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents company name contains the string c.
	public DaytripExtend[] searchByCompany(String comp){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByCompany(comp, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that contain the search string in their parents description
	//Not used in main search function
	//Use:	DaytripExtend[] I = searchInDesc(d);
	//pre:	d is a String.
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents description contains the string d.
	public DaytripExtend[] searchInDesc(String desc){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchInDesc(desc, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that have Hotel as pickup location
	//Not used in main search function
	//Use:	DaytripExtend[] I = searchByPickup(h);
	//Pre:	h is a String.
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents pickup locations (hotel names) include h.
	public DaytripExtend[] searchByPickup(String hotel){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByPickup(hotel, a);
		return createInfo(a);
	}
	
	//Returns every IndivDayTrips in database.
	//Use:	DaytripExtend[] I = getAll();
	//Pre:	N/A
	//Post:	I contains information extracted from all IndivDayTrips in database
	public DaytripExtend[] getAll(){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		return createInfo(a);
	}
	
	//HELPER FUNCTIONS
	
	//Checks if array b contains at least one element of array a
	private boolean matchOne(String[] a, String[] b){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < b.length; j++){
				if(a[i].equals(b[j])){
					return true;
				}
			}
		}
		return false;
	}
	
	//Use:	DaytripExtend[] I = createInfo(child)
	//Pre:	child is an array of IndivDayTrips
	//Post:	I is an array of Info objects containing data 
	//		extracted from the contents of child and their
	//		parents.
	protected static DaytripExtend[] createInfo(IndivDayTrip[] child){
		DaytripExtend[] temp = new DaytripExtend[child.length];
		for(int i = 0; i < child.length; i++){
			temp[i] = createInfo(child[i]);
		}
		return temp;
	}
	
	protected static DaytripExtend createInfo(IndivDayTrip child){
		DayTrip parent = child.getParent();
		int tId = child.getId();
		String tName = parent.getName();
		Date tSTime = child.getStartTime();
		Date tETime = child.getEndTime();
		String tLoc = parent.getRegion();
		int tPrice = parent.getPrice();
		int tSeats = child.getNumSeatsAvail();
		String tCat = parent.getCategory();
		String[] tDeal = parent.getCompany();
		return new DaytripExtend(tSTime, tETime, tLoc, tPrice, tSeats, tCat, tDeal, tName, tId);
	}
	
	//TODO remove
	public void sort(char param){

	}

	//TODO implement or remove
	public DayTrip[] suggestions(DayTrip trip){
		DayTrip[] a = null;
		return a;
	}

	//TODO remove
	public DayTrip[] selectTrip(DayTrip d){
		DayTrip[] a = null;
		return a;
	};


	public static void main(String[] args) {
		System.out.println("�etta er Searcher Klasinn");
	}
	

}
