package classes;

import java.util.*;
//import interfaces.*;
import metaSearchEngine.program.*;

public class DaytripSearcher /*implements I_Searcher*/{
	
	
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
	 * 	String[] Category:		Category of parent daytrip, if null search by category will not be perfomed
	 *
	 *	Use:	ArrayList<DaytripAbstract> d = DaytripSearcher.search(c)
	 *	Pre:	c is a DayTripSearchCriteria object as described above
	 *	Post:	d contains information extracted from IndivDayTrips matching the criteria in c.
	 *
	*/
	public static ArrayList<DaytripAbstract> search(DayTripSearchCriteria crit){
		Database.connectToDatabase();
		IndivDayTrip[] output = IndivDayTripList.pullIndivDayTrip();
		
		String tName = crit.getName();
		String tLoc = crit.getLocation();
		Date tSTime = crit.getStartTime();
		Date tETime = crit.getEndTime();
		int[] tPRange = crit.getPriceRange();
		int tSeats = crit.getNumParticipants();
		String[] tCat = crit.getCategory();
		
		if(tName != null)	output = DaytripSearcher.searchByName(tName, output);
		if(tLoc != null)	output = searchByLoc(tLoc, output);
		if(tSTime != null && tETime != null){
			output = searchByTime(tSTime, tETime, output);
		}
		if(tPRange != null) output = searchByPrice(tPRange, output);
		if(tSeats > 0)	output = searchBySize(tSeats, output);
		if(tCat != null)	output = searchByCategory(tCat, output);
		Database.closeDatabase();
		return createInfo(output);
	}
	
	//PRIVATE SEARCH HELPER FUNCTIONS
	
	
	//Use:	IndivDayTrip[] output = searchByName(n, in);
	//Pre:	n is a string representing name of desired daytrip
	//		in is the IndivDayTrip array that the function searches through
	//Post:	output is an array of IndivDayTrips in in whose parent's name contain
	//		string n.
	private static IndivDayTrip[] searchByName(String name, IndivDayTrip[] input){
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
	
	private static IndivDayTrip[] searchByLoc(String loc, IndivDayTrip[] input){
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
	
	private static IndivDayTrip[] searchByTime(Date startTime, Date endTime, IndivDayTrip[] input){
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
	
	private static IndivDayTrip[] searchByPrice(int price[], IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			int money = parent.getPrice();
			if((price[0] >= money || price[0] < 0) && (price[1] <= money || price[1] < 0)){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);		
	}
	
	private static IndivDayTrip[] searchBySize(int size, IndivDayTrip[] input){
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
	
	private static IndivDayTrip[] searchByCategory(String[] cat, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String c = parent.getCategory();
			for(int j = 0; j < cat.length; j++){
				if(c.toLowerCase().contains(cat[j].toLowerCase())){
					output.add(input[i]);
					k++;
					break;
				}
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	private static IndivDayTrip[] searchByCompany(String comp, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String c = parent.getCompany();
			if(c.toLowerCase().contains(comp.toLowerCase())){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);
	}
	
	private static IndivDayTrip[] searchByKeywords(String[] keywords, IndivDayTrip[] input){
		int k = 0;
		Vector<IndivDayTrip> output = new Vector<IndivDayTrip>();
		for(int i = 0; i < input.length; i++){
			DayTrip parent = input[i].getParent();
			String[] kWords = parent.getKeywords();
			if(matchOne(keywords, kWords)){
				output.add(input[i]);
				k++;
			}
		}
		IndivDayTrip[] truOp = new IndivDayTrip[k];
		return output.toArray(truOp);			
	}
	
	private static IndivDayTrip[] searchInDesc(String desc, IndivDayTrip[] input){
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
	
	private static IndivDayTrip[] searchByPickup(String hotel, IndivDayTrip[] input){
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
	
	protected static IndivDayTrip searchByID(int ID){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
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
	//Use:	ArrayList<DaytripAbstract> I = searchByName(n);
	//Pre:	n is a string
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents name contains n.
	public static ArrayList<DaytripAbstract> searchByName(String name){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByName(name, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips by their parents location
	//Use:	ArrayList<DaytripAbstract> I = searchByLoc(l);
	//Pre:	l is a string
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents location is l
	public static ArrayList<DaytripAbstract> searchByLoc(String loc){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByLoc(loc, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips within a certain timeframe
	//Use:	ArrayList<DaytripAbstract> I = searchByTime(pre, post);
	//Pre:	pre and post are Date objects. one, but not both
	//		can have the value null. post contains a date later
	//		than pre.
	//Post:	I contains information extracted from all IndivDayTrips
	//		within the timeframe between pre and post (inclusive)
	public static ArrayList<DaytripAbstract> searchByTime(Date pre, Date post){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByTime(pre, post, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips with a parent within a certain pricerange
	//Use:	ArrayList<DaytripAbstract> I = searchByPrice(p);
	//Pre:	p is a two value int array. p[1] > p[0].
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents price lies within the two values in p (inclusive).
	public static ArrayList<DaytripAbstract> searchByPrice(int[] price){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByPrice(price, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that have a certain number of seats available
	//Use:	ArrayList<DaytripAbstract> I = searchBySize(int s);
	//Pre:	s is an integer. s > 0
	//Post:	I contains information extracted from all IndivDayTrips
	//		with a number of available seats greater or equal to s.
	public static ArrayList<DaytripAbstract> searchBySize(int size){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchBySize(size, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips whose category matches the search strings
	//Use:	ArrayList<DaytripAbstract> I = searchByCategory(String[] c);
	//Pre:	c is a String.
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose category name contains at least one  of the strings in c.
	public static ArrayList<DaytripAbstract> searchByCategory(String[] cat){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByCategory(cat, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips from a specific company
	//Not used in main search function
	//Use:	ArrayList<DaytripAbstract> I = searchByCompany(c);
	//Pre:	c is a String
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents company name contains the string c.
	public static ArrayList<DaytripAbstract> searchByCompany(String comp){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByCompany(comp, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that contain the search string in their parents description
	//Not used in main search function
	//Use:	ArrayList<DaytripAbstract> I = searchInDesc(d);
	//pre:	d is a String.
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents description contains the string d.
	public static ArrayList<DaytripAbstract> searchInDesc(String desc){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchInDesc(desc, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that have Hotel as pickup location
	//Not used in main search function
	//Use:	ArrayList<DaytripAbstract> I = searchByPickup(h);
	//Pre:	h is a String.
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parents pickup locations (hotel names) include h.
	public static ArrayList<DaytripAbstract> searchByPickup(String hotel){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByPickup(hotel, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips whose parents have at least one keyword in common with a given array
	//Not used in main search function
	//Use:	ArrayList<DaytripAbstract> I = searchByKeywords(k);
	//Pre:	k is a String array.
	//Post:	I contains information extracted from all IndivDayTrips
	//		whose parent has at least one keyword string in common with k
	public static ArrayList<DaytripAbstract> searchByKeywords(String[] keywords){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		a = searchByKeywords(keywords, a);
		return createInfo(a);
	}	
	
	//Returns every IndivDayTrips in database.
	//Use:	ArrayList<DaytripAbstract> I = getAll();
	//Pre:	N/A
	//Post:	I contains information extracted from all IndivDayTrips in database
	public static ArrayList<DaytripAbstract> getAll(){
		IndivDayTrip[] a = IndivDayTripList.pullIndivDayTrip();
		return createInfo(a);
	}
	
	//HELPER FUNCTIONS
	
	//Checks if array b contains at least one element of array a
	private static boolean matchOne(String[] a, String[] b){
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
	protected static ArrayList<DaytripAbstract> createInfo(IndivDayTrip[] child){
		ArrayList<DaytripAbstract> temp = new ArrayList<DaytripAbstract>();
		for(int i = 0; i < child.length; i++){
			temp.add(createInfo(child[i]));
		}
		return temp;
	}
	
	protected static DaytripAbstract createInfo(IndivDayTrip child){
		DayTrip parent = child.getParent();
		int tId = child.getId();
		String tName = parent.getName();
		Date tSTime = child.getStartTime();
		Date tETime = child.getEndTime();
		String tLoc = parent.getRegion();
		int tPrice = parent.getPrice();
		int tSeats = child.getNumSeatsAvail();
		String tCat = parent.getCategory();
		String tDeal = parent.getCompany();
		String[] dealInfo = CompanyList.getCompanyDetails(tDeal);
		System.out.println(tName + " " + tPrice);
		return new DaytripExtend(tSTime, tETime, tLoc, tPrice, tSeats, tCat, dealInfo, tName, tId);
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
