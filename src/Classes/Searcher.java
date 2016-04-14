package classes;

import java.util.*;
import interfaces.*;

public class Searcher implements I_Searcher{
	
	private I_IndivDayTripList indivTrips;

	public Searcher(I_IndivDayTripList i){
		this.indivTrips = i;
	}
	
	/*	MAIN SEARCH_BY_CRITERIA FUNCTION
	 * 	returns day trip information based on input from a given DayTripSearchCriteria object.
	 * 	The input object contains the following criteria:
	 * 	String name:			Name of parent daytrip
	 * 	String location:		Location of parent daytrip
	 * 	String startTime:		Minimum start time of daytrip
	 * 	String endTime:			Maximum end time of daytrip
	 * 	int[] priceRange:		The range within which the price of the daytrip must fall,
	 * 							priceRange[0] for lower bound, priceRange[1] for upper bound
	 * 	int numParticipants:	The minimum seats left of daytrip
	 * 	String Category:		Category of parent daytrip
	 *	
	 *	If any of these criteria have the value null, they will be skipped. In case of startTime, endTime
	 *	and priceRange this can be used to implement boundless search in one direction.
	*/
	public Info[] search(DayTripSearchCriteria crit){
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
			String c = parent.getCompany();
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
	
	
	
	//PUBLIC SINGLE CRITERIA SEARCH FUNCTIONS
	
	//returns all IndivDayTrips by their parents name
	public Info[] searchByName(String name){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByName(name, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips by their parents location
	public Info[] searchByLoc(String loc){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByLoc(loc, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips within a certain timeframe
	public Info[] searchByTime(Date pre, Date post){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByTime(pre, post, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips with a parent within a certain pricerange
	public Info[] searchByPrice(int[] price){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByPrice(price, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that have a certain number of seats available
	public Info[] searchBySize(int size){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchBySize(size, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips whose parents have at least one keyword in common with a giver array
	public Info[] searchByKeywords(String[] keywords){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByKeywords(keywords, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips from a specific company
	//Not used in main search function
	public Info[] searchByCompany(String comp){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByCompany(comp, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that contain the search string in their parents description
	//Not used in main search function
	public Info[] searchInDesc(String desc){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchInDesc(desc, a);
		return createInfo(a);
	}
	
	//returns all IndivDayTrips that have Hotel as pickup location
	//Not used in main search function
	public Info[] searchByPickup(String hotel){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		a = searchByPickup(hotel, a);
		return createInfo(a);
	}
	
	public Info[] getAll(){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		return createInfo(a);
	}
	
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
	
	//Use:	Info[] I = createInfo(child)
	//Pre:	child is an array of IndivDayTrips
	//Post:	I is an array of Info objects containing data 
	//		extracted from the contents of child and their
	//		parents.
	private Info[] createInfo(IndivDayTrip[] child){
		Info[] temp = new Info[child.length];
		for(int i = 0; i < child.length; i++){
			DayTrip parent = child[i].getParent();
			temp[i].setIndivId(child[i].getId());
			temp[i].setName(parent.getName());
			temp[i].setStartTime(child[i].getStartTime());
			temp[i].setEndTime(child[i].getEndTime());
			temp[i].setLocation(parent.getRegion());
			temp[i].setPrice(parent.getPrice());
			temp[i].setNumSeatsAvail(child[i].getNumSeatsAvail());
			temp[i].setCategory(parent.getCategory());
		}
		return temp;
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
