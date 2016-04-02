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
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
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
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
		  }
	}