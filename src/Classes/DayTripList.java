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
		String[] comp = d.getCompany();
		
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

		if(!Database.matchDB(comp[0], "COMPANY", "NAME")){
			String cInject = "INSERT INTO COMPANY(NAME, SIMANUMER, EMAIL) VALUES('"
							 + comp[0] + "', '" + comp[1] + "', '" + comp[2] + "');";
			Database.insert(cInject);
		}
		
		String inject = "INSERT INTO DAYTRIPS(NAME,COMPANY,PRICE,DESCR,KEYWORDS,CATEGORY,HOTELPICKUP) "
						+ "VALUES('" + name + "', '" + comp[0] + "', '" + price + "', '" + desc + "', '"
						+ sKeyw + "', '" + cat + "', '" + sPickup + "');";
		
    	Database.insert(inject);
    }

    @Override
    public DayTrip[] pullDayTrip() {
        //TODO Klára
        ResultSet rs = Database.getTable("Daytrips");
        List<DayTrip> result = new ArrayList<DayTrip>();
        return null;
    }

    @Override
    public void removeDayTrip(DayTrip d) {
        // TODO Auto-generated method stub
        
    }


}
