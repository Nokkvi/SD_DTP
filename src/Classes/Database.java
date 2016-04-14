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
		      
		      String sql = "INSERT INTO COMPANY(NAME,SIMANUMER,EMAIL)" +
		    		  	   "VALUES('Reykjavik Excursions', '5805400','main@re.is')";
		      stmt.executeUpdate(sql);
		      
		      /*
		      String sql = "INSERT INTO Daytrips(NAME,COMPANY,PRICE,DESCR,KEYWORDS,CATEGORY,HOTELPICKUP) " +
		                   "VALUES('Essential Iceland', 'Reykjavik Excursions',42900, 'Enjoy an amazing tour through a landscape of extreme contrasts, full of history and geology.',"+
		                   "'Thingvellir - Vikings - Kaldidalur - Langjokull - Lava field - Waterfalls - Hot Springs', 'Adventure', 'No Pickup');";
		      stmt.executeUpdate(sql);
		      */
		      /*
		      String sql = "INSERT INTO indivDaytrips(ID,STARTTIME,ENDTIME,DAYTRIP,NUMSEATSAVAIL) " +
		    		  	   "VALUES(0096, '2016-04-22 09:00:00.000', '2016-04-22 19:00:00.000', 'Essential Iceland', 20);";
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO indivDaytrips(ID,STARTTIME,ENDTIME,DAYTRIP,NUMSEATSAVAIL) " +
	    		  	   "VALUES(0097, '2016-04-23 09:00:00.000', '2016-04-23 19:00:00.000', 'Essential Iceland', 20);";
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO indivDaytrips(ID,STARTTIME,ENDTIME,DAYTRIP,NUMSEATSAVAIL) " +
	    		  	   "VALUES(009, '2016-04-24 09:00:00.000', '2016-04-24 19:00:00.000', 'Essential Iceland', 20);";
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO indivDaytrips(ID,STARTTIME,ENDTIME,DAYTRIP,NUMSEATSAVAIL) " +
	    		  	   "VALUES(0094, '2016-04-25 09:00:00.000', '2016-04-25 19:00:00.000', 'Essential Iceland', 20);";
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO indivDaytrips(ID,STARTTIME,ENDTIME,DAYTRIP,NUMSEATSAVAIL) " +
	    		  	   "VALUES(0099, '2016-04-28 09:00:00.000', '2016-04-28 19:00:00.000', 'Essential Iceland', 20);";
		      stmt.executeUpdate(sql);
		      */
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