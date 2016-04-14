package classes;

import interfaces.I_Database;

//STEP 1. Import required packages
import java.sql.*;

public class Database implements I_Database {

	  public static void main( String args[] )
	  {
		    Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:Database.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      /*
		      String sql = "DELETE from indivDaytrips where ID=71;";
		      stmt.executeUpdate(sql);
		      */
		      /*
		      String sql = "INSERT INTO Daytrips(NAME,COMPANY,PRICE,DESCR,KEYWORDS,CATEGORY,HOTELPICKUP) " +
		                   "VALUES('Essential Iceland', 'Reykjavik Excursions',42900, 'Enjoy an amazing tour through a landscape of extreme contrasts, full of history and geology.',"+
		                   "'Thingvellir - Vikings - Kaldidalur - Langjokull - Lava field - Waterfalls - Hot Springs', 'Adventure', 'No Pickup');";
		      stmt.executeUpdate(sql);
		      */
		      
		      String sql = "INSERT INTO indivDaytrips(ID,STARTTIME,ENDTIME,DAYTRIP,NUMSEATSAVAIL) " +
		    		  	   "VALUES(0101, '2016-04-29 09:00:00.000', '2016-04-29 19:00:00.000', 'Essential Iceland', 20);";
		      stmt.executeUpdate(sql);
		      
		      stmt.close();
		      c.commit();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
		  }
	}