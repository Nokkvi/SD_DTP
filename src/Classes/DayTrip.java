package classes;
import interfaces.*;

public class DayTrip implements I_DayTrip {
	private String name;
	private String category;
	private String[] pickupLocation;
	private String descr;
	private String region;
	private String[] keyWords; //Af hverju var �etta static???
	private int price;
	private String company;
	private double rating;
	
	public DayTrip(String name,
			String category,
			String company,
			String[] pickupLocation,
			String[] keywords,
			String region,
			String descr,
			int pr,
			double rating){
		this.name = name;
		this.category = category;
		this.pickupLocation = pickupLocation;
		this.region = region;
		descr = null;
		keyWords = null;
		this.price = pr;
		this.company = company;
		this.rating = rating;
	}
	public static IndivDayTrip selectIndiv(IndivDayTrip indiv){
		return indiv;
	}
	
	public void addKeyword(String keyWord){
		int size = keyWords.length;
		if(size < 15){
			keyWords[size] = keyWord;
		}else{
			System.out.println("Too many Keywords!");
		}
	}
	
	public void editDesc(String newDescr){
		descr = newDescr;
	}
	
	public Rating rate(int n, String comment, User user){
		Rating rating = new Rating(this, n, comment, user);
		RatingList.addRating(rating);
		return rating;
	}
	
	public String getDesc(){
		return this.descr;
	}
	
	public String getRegion(){
		return this.region;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public String getCategory(){
		return this.category;
	}
	
	public String[] getPickups(){
		return this.pickupLocation;
	}
	
	public String[] getKeywords(){
		return this.keyWords;
	}
	
	public String getCompany(){
		return this.company;
	}
	
	public double getRating(){
	    return this.rating;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�etta er DayTrip Klasinn");
	}
	@Override
	public IndivDayTrip selectIndiv(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
