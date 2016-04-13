package classes;

import java.util.Date;
import interfaces.*;
import java.util.Vector;
//import mockObjects.M_IndivDayTripListGeneral;

public class Searcher implements I_Searcher{
	//private DayTrip[] temp;
	//private IndivDayTrip[] indivTemp;
	private DayTripList trips;
	private I_IndivDayTripList indivTrips;
	//private Info output;

	public Searcher(I_IndivDayTripList i){
		//this.temp = new DayTrip[20];
		//this.indivTemp = new IndivDayTrip[20];
		this.trips = new DayTripList();
		this.indivTrips = i;
	}

	//returns all IndivDayTrips that take place after pre and before post
	public Info[] searchByTime(Date pre, Date post){
		IndivDayTrip[] a = indivTrips.pullIndivDayTrip();
		Vector<Info> output = new Vector<Info>();
		for(int i = 0; i < a.length; i++){
			if((pre.compareTo(a[i].getStartTime())<0)&&(post.compareTo(a[i].getEndTime())>0)){
				createInfo(a[i], output);
			}
		}
		return (Info[]) output.toArray();
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
	
	//Checks if array b contains all elements of array a
	private boolean matchAll(String[] a, String[] b){
		int k = 0;
		boolean match[] = new boolean[a.length];
		while(k < a.length){
			for(int j = 0; j < b.length; j++){
				if(a[k].equals(b[j])){
					match[k] = true;
				}
				break;
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

	public void sort(char param){

	}

	public DayTrip[] suggestions(DayTrip trip){
		DayTrip[] a = null;
		return a;
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

	//Spurning hvort við þurfum þetta
	public DayTrip[] selectTrip(DayTrip d){
		DayTrip[] a = null;
		return a;
	};


	public static void main(String[] args) {
		System.out.println("ï¿½etta er Searcher Klasinn");
	}

}
