package classes;

import java.util.*;
import interfaces.*;
import java.text.DateFormat;
//import mockObjects.M_IndivDayTripListGeneral;

public class Searcher implements I_Searcher{
	//private DayTrip[] temp;
	private IndivDayTrip[] indivTemp;
	//private DayTripList trips;
	private I_IndivDayTripList indivTrips;
	//private Info output;

	public Searcher(I_IndivDayTripList i){
		//this.temp = new DayTrip[20];
		//this.trips = new DayTripList();
		this.indivTrips = i;
		this.indivTemp = i.pullIndivDayTrip();
	}
	
	/*	returns day trip information based on input from a given DayTripSearchCriteria object.
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
		refreshTrips();
		IndivDayTrip[] output = indivTemp;
		
		String tName = crit.getName();
		String tLoc = crit.getLocation();
		String tSTime = crit.getStartTime();
		String tETime = crit.getEndTime();
		int[] tPRange = crit.getPriceRange();
		int tSeats = crit.getNumParticipants();
		String[] tCat = crit.getCategory();
		
		if(tName != null)	output = this.searchByName(tName, output);
		if(tLoc != null)	output = this.searchByLoc(tLoc, output);
		if(tSTime != null && tETime != null){
			DateFormat df = DateFormat.getDateInstance();
			Date startDate = null; 
			Date endDate = null;
			if(tSTime != null)	startDate = df.parse(tSTime);
			if(tETime != null)	endDate = df.parse(tETime);
			output = this.searchByTime(startDate, endDate, output);
		}
		if(tPRange[0] != 0 && tPRange[1] != 0) output = this.searchByPrice(tPRange, output);
		if(tSeats != 0)	output = this.searchBySize(tSeats, output);
		if(tCat != null)	output = this.searchByKeywords(tCat, output);
		
		return createInfo(output);
	}
	
	//returns all IndivDayTrips by their parents name
	public Info[] searchByName(String name){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		int k = 0;
		Vector<Info> output = new Vector<Info>();
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			String n = parent.getName();
			if(n.toLowerCase().contains(name.toLowerCase())){
				createInfo(a[i], output);
				k++;
			}
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}
	
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
	
	//returns all IndivDayTrips from a specific company
	public Info[] searchByCompany(String comp){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		int k = 0;
		Vector<Info> output = new Vector<Info>();
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			String c = parent.getCompany();
			if(comp.equals(c)){
				createInfo(a[i], output);
				k++;
			}
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}

	//returns all IndivDayTrips that take place after pre and before post
	public Info[] searchByTime(Date pre, Date post){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		Vector<Info> output = new Vector<Info>();
		int k = 0;
		for(int i = 0; i < a.length; i++){
			if((pre.compareTo(a[i].getStartTime())<0)&&(post.compareTo(a[i].getEndTime())>0)){
				createInfo(a[i], output);
			}
			k++;
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}

	//returns all IndivDayTrips that have seatsAvailable equal to or exceeding size
	public Info[] searchBySize(int size){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		int k = 0;
		Vector<Info> output = new Vector<Info>();
		for(int i = 0; i < a.length; i++){
			if(size <= a[i].getNumSeatsAvail()){
				createInfo(a[i], output);
				k++;
			}
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}
	
	//returns all IndivDayTrips that contain the search string in their parents description
	public Info[] searchInDesc(String str){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		int k = 0;
		Vector<Info> output = new Vector<Info>();
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			if(parent.getDesc().toLowerCase().contains(str.toLowerCase())){
				createInfo(a[i], output);
				k++;
			}
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}
	
	//returns all IndivDayTrips that have Hotel as pickup location
	public Info[] searchByPickup(String hotel){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		Vector<Info> output = new Vector<Info>();
		int k = 0;
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			String[] h = parent.getPickups();
			for(int j = 0; j < h.length; j++){
				if(hotel.equals(h[i])){
					createInfo(a[i], output);
					k++;
				}
			}
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}

	//returns all DayTrips that have loc as a location
	//TODO: Muna að breyta formatti á region
	public Info[] searchByLoc(String loc){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		Vector<Info> output = new Vector<Info>();
		int k = 0;
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			String r = parent.getRegion();
			if(loc.equals(r)){
				createInfo(a[i], output);
				k++;
			}
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}

	//returns all DayTrips that contain any of the following keywords
	public Info[] searchByKeywords(String[] keywords, boolean all){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		Vector<Info> output = new Vector<Info>();
		Vector<DayTrip> doneParent = new Vector<DayTrip>();
		int k = 0;
		for(int i = 0; i < a.length; i++){
			DayTrip parent = a[i].getParent();
			if(doneParent.contains(parent)){
				createInfo(a[i], output);
				k++;
			}else{
				String[] pkey = parent.getKeywords();
				if((matchAll(pkey, keywords) && all) || (matchOne(pkey, keywords) && !all)){
					createInfo(a[i], output);
					doneParent.add(parent);
					k++;
				}
			}
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}
	
	public Info[] getAll(){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		Vector<Info> output = new Vector<Info>();
		int k = 0;
		for(int i = 0; i < a.length; i++){
			createInfo(a[i], output);
			k++;
		}
		Info[] truOp = new Info[k];
		return output.toArray(truOp);
	}
	
	//Restores the array of IndivDayTrips to reflect the current state of the IndivDayTrip database,
	//In case any changes have been made.
	public void refreshTrips(){
		this.indivTemp = indivTrips.pullIndivDayTrip();
	}
	
	//Checks if array b contains all elements of array a
	private boolean matchAll(String[] a, String[] b){
		int k = 0;
		boolean match[] = new boolean[a.length];
		while(k < a.length){
			for(int j = 0; j < b.length; j++){
				if(a[k].equals(b[j])){
					match[k] = true;
					break;
				}
			}
			if(match[k] == false){
				return false;
			}
			k++;
		}
		return true;
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
	
	private void createInfo(IndivDayTrip child, Vector<Info> output){
		DayTrip parent = child.getParent();
		Info temp = new Info();
		temp.setIndivId(child.getId());
		temp.setName(parent.getName());
		temp.setStartTime(child.getStartTime());
		temp.setEndTime(child.getEndTime());
		temp.setLocation(parent.getRegion());
		temp.setPrice(parent.getPrice());
		temp.setNumSeatsAvail(child.getNumSeatsAvail());
		temp.setCategory(parent.getCategory());
		output.add(temp);
	}
	
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
	
	public void sort(char param){

	}

	public DayTrip[] suggestions(DayTrip trip){
		DayTrip[] a = null;
		return a;
	}

	//Spurning hvort við þurfum þetta
	public DayTrip[] selectTrip(DayTrip d){
		DayTrip[] a = null;
		return a;
	};


	public static void main(String[] args) {
		System.out.println("ï¿½etta er Searcher Klasinn");
	}
	

}
