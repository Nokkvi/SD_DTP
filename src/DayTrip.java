import java.util.*;

public class DayTrip {
	private String name;
	private String[] category;
	private Hotel[] PickupLocation;
	private String address;
	private static String descr;
	private RatingList ratings;
	private String region;
	private static String[] keyWords;
	private IndivDayTripList indiv;
	
	public DayTrip(String name,
			String[] category,
			String[] comp,
			Hotel[] PickupLocation,
			String address,
			String region,
			RatingList ratings,
			Double toRating,
			IndivDayTripList indiv){
		this.name = name;
		this.category = category;
		this.PickupLocation = PickupLocation;
		this.address = address;
		this.region = region;
		this.ratings = ratings;
		descr = null;
		this.indiv = indiv;
		keyWords = null;
	}
	public static IndivDayTrip selectIndiv(IndivDayTrip indiv){
		return indiv;
	}
	
	public static void addKeyWord(String keyWord){
		int size = keyWords.length;
		if(size < 15){
			keyWords[size] = keyWord;
		}
	}
	
	public static void editDesc(String newDescr){
		descr = newDescr;
	}
	
	public Rating rate(int n, String comment, User user){
		Rating rating = new Rating(this, n, comment, user);
		return rating;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Þetta er DayTrip Klasinn");
	}

}
