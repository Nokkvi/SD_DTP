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
		      c = DriverManager.getConnection("jdbc:sqlite:smjee.db");
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "CREATE TABLE Daytrip " +
		                   "(NAME CHAR(50) PRIMARY KEY  NOT NULL," +
		                   " COMPANY        CHAR(50), " + 
		                   " Rating           REAL, " + 
		                   " ADDRESS        CHAR(50), " + 
		                   " PRICE            INT,"+
		                   " DESCR			CHAR(100)," + 
		                   " KEYWORDS		CHAR(255)," +
		                   " CATEGORY		CHAR(255))"; 
		      stmt.executeUpdate(sql);
		      
		      sql = "CREATE TABLE indivDaytrip " +
		    		   "(ID INT PRIMARY KEY  NOT NULL," +
		    		   " STARTTIME        DATE, " + 
	                   " ENDTIME          DATE, " + 
	                   " DAYTRIP          CHAR(50), " + 
	                   " NUMSEATSAVAIL    INT)"; 
		      stmt.executeUpdate(sql);
		      
		      sql = "CREATE TABLE RatingList " +
	                   "(NAME CHAR(50) PRIMARY KEY  NOT NULL," +
	                   " RATETIME         DATE, " + 
	                   " Rating           INT, " + 
	                   " COMMENT        CHAR(255), " + 
	                   " USERID 		  INT)";
		      stmt.executeUpdate(sql);
		      
		      sql = "CREATE TABLE Users " +
		    		   " (USERID INT PRIMARY KEY NOT NULL," +
	                   " NAME         CHAR(50), " + 
	                   " TOWN         CHAR(50), " + 
	                   " HOTEL        CHAR(50))";
		     
		      stmt.executeUpdate(sql);
		      sql = "CREATE TABLE Booking " +
	                   " (USERID INT PRIMARY KEY NOT NULL," + 
	                   " TRIPID          INT, " + 
	                   " PARENT         CHAR(50), " + 
	                   " SEATS    		 INT)";
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
		  }
	}