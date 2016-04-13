package classes;
public class DayTrip {
	private String name;
	private String category;
	private Hotel[] pickupLocation;
	private String address;
	private static String descr;
	private RatingList ratings;
	private String region;
	private String[] keyWords; //Af hverju var þetta static???
	private IndivDayTripList indiv;
	private int price;
	private String company;
	
	public DayTrip(String name,
			String category,
			String comp,
			Hotel[] pickupLocation,
			String address,
			String region,
			int pr){
		this.name = name;
		this.category = category;
		this.pickupLocation = pickupLocation;
		this.address = address;
		this.region = region;
		this.ratings = new RatingList();
		descr = null;
		this.indiv = new IndivDayTripList();
		keyWords = null;
		this.price = pr;
		this.company = comp;
	}
	public static IndivDayTrip selectIndiv(IndivDayTrip indiv){
		return indiv;
	}
	
	public void addKeyWord(String keyWord){
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
		RatingList.addRating(rating);
		return rating;
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
	
	public Hotel[] getPickups(){
		return this.pickupLocation;
	}
	
	public String[] getKeywords(){
		return this.keyWords;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ï¿½etta er DayTrip Klasinn");
	}

}
