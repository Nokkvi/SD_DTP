package classes;

import interfaces.*;
import java.sql.*;
import java.util.*;



public class DayTripList implements I_DayTripList {
	
    @Override
    public void addDayTrip(DayTrip d) {
		String name = d.getName();
		String cat = d.getCategory();
		String[] pickup = d.getPickups();
		String desc = d.getDesc();
		String loc = d.getRegion();
		String[] keyw = d.getKeywords();
		String price = Integer.toString(d.getPrice());
		String comp = d.getCompany();
		
		String sPickup = "";
		String sKeyw = "";
		
		if(pickup.length > 0){
			sPickup = pickup[0];
			for(int i = 1; i < pickup.length; i++){
				sPickup = sPickup + ", " + pickup[i];
			}
		}
		
		if(keyw.length > 0){
			sKeyw = keyw[0];
			for(int j = 1; j < keyw.length; j++){
				sKeyw = sKeyw + " - " + keyw[j];
			}
		}
		
		String inject = "INSERT INTO DAYTRIPS(NAME,COMPANY,PRICE,DESCR,KEYWORDS,CATEGORY,HOTELPICKUP) "
						+ "VALUES('" + name + "', '" + comp + "', '" + price + "', '" + desc + "', '"
						+ sKeyw + "', '" + cat + "', '" + sPickup + "');";
		
    	Database.insert(inject);
    }

    @Override
    public DayTrip[] pullDayTrip() {
        //TODO Klára
        ResultSet rs = Database.getTable("Daytrips");
        List<DayTrip> result = new ArrayList<DayTrip>();
        try {
            while (rs.next()){
                String name = rs.getString(1);
                String company = rs.getString(2);
                double rating = rs.getFloat(3);
                int price = rs.getInt(4);

                String description = rs.getString(5);
                String[] keywords = rs.getString(6).split(" - ");
                String category = rs.getString(7);
                String[] pickup = rs.getString(8).split(", ");
                String location = rs.getString(9);
                result.add(new DayTrip(name, category, company, pickup, keywords, location, description, price, rating));
                return (DayTrip[]) result.toArray();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public void removeDayTrip(DayTrip d) {
        // TODO Auto-generated method stub
        
    }


}
