package classes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.*;


public class BookInfoList{

	public static void main(String[] args) {
		System.out.println("�etta er BookInfoList Klasinn");

	}

	public void addBooking(BookingInfo b) {
		Database.connectToDatabase();
		User user = b.getUser();
		IndivDayTrip trip = b.getTrip();
		DayTrip parent = trip.getParent();
		int seats = b.getSeats();
		
		if(!Database.matchDB(user.getId(), "USERS",  "ID")){
			UserList.addUser(user.getId(), user.getHotel(), user.getTown(), user.getName(), user.getEmail());
		}
		
		//TODO Spurning um User ID sem int e�a String
		int uID = Integer.parseInt(user.getId());
		int tID = trip.getId();
		String pNAM = parent.getName();
		
		String inject = "INSERT INTO BOOKING(USERID, TRIPID, PARENT, SEATS) "
						+ "VALUES('" + uID + "', '" + tID + "', '" + pNAM + "', '" + seats + "');";
		
    	Database.insert(inject);
    	Database.closeDatabase();
	}
	
	public BookingInfo[] pullBooking() {
		Database.connectToDatabase();
        ResultSet rs = Database.getTable("booking");
        List<BookingInfo> result = new ArrayList<BookingInfo>();
        try {
        	int k = 0;
            while (rs.next()){
            	int uID = rs.getInt(1);
            	int tID = rs.getInt(2);
            	String parent = rs.getString(3);
            	int sumS = rs.getInt(4);            	
            	
            	ResultSet rsp = Database.execute("SELECT * FROM Daytrips WHERE name="+parent);
            	ResultSet rst = Database.execute("SELECT * FROM indivDaytrips WHERE ID="+tID);
            	ResultSet rsu = Database.execute("SELECT * FROM Users WHERE ID="+uID);
            	
            	rsp.next();
            	rst.next();
            	rsu.next();
            	//User(String ID, String h, String s, String n, String mail)
            	String uIdent = Integer.toString(uID);
            	String uName = rsu.getString(2);
            	String uTown = rsu.getString(3);
            	String uHotl = rsu.getString(4);
            	String uMail = rsu.getString(5);
            	User uInput = new User(uIdent, uName, uTown, uHotl, uMail);
            	
            	//pName == parent
            	String pComp = rsp.getString(2);
            	double pRate = rsp.getFloat(3);
                int pPrice = rsp.getInt(4);
                String pDesc = rsp.getString(5);
                String[] pKeyw = rsp.getString(6).split(" - ");
                String pCat = rsp.getString(7);
                String[] pPick = rsp.getString(8).split(", ");
                String pLoc = rsp.getString(9);
                DayTrip pInput = new DayTrip(parent, pCat, pComp, pPick, pKeyw, pLoc, pDesc, pPrice, pRate);
                
                //tID == tID
            	String tSd = rst.getString(2);
            	String tEd = rst.getString(3);
            	//tParent = parent
            	int numSeats = rst.getInt(5);
            	int newSeats = numSeats - sumS;            	
            	Date startD = new Date(Date.parse(tSd));
            	Date endD = new Date(Date.parse(tEd));
            	IndivDayTrip tInput = new IndivDayTrip(tID, startD, endD, newSeats, pInput);
            	
            	rst = Database.execute("UPDATE indivDaytrips SET NUMSEATSAVAIL="+newSeats+" WHERE ID="+tID);
            	
                result.add(new BookingInfo(uInput, tInput, sumS));
                k++;
            }
            BookingInfo[] truOP = new BookingInfo[k];
            Database.closeDatabase();
            return result.toArray(truOP);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Database.closeDatabase();
            return null;
        }
	}

	public void removeBooking(BookingInfo b) {
		Database.connectToDatabase();
		String uId = b.getUser().getId();
		int tId = b.getTrip().getId();
		
		String cond = "USERUD = "+uId+" AND TRIPID = "+tId+";";
		ResultSet rs = Database.deleteEntry("indivDaytrips", cond);
		Database.closeDatabase();
	}

}
