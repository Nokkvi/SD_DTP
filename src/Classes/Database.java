package classes;

import interfaces.I_Database;

//STEP 1. Import required packages
import java.sql.*;
import java.util.*;

public class Database implements I_Database {
    static Connection c;
    static Statement stmt;

    public static void main( String args[] )
    {
        c = null;
        stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            /*
		      String sql = "INSERT INTO COMPANY(NAME,SIMANUMER,EMAIL)" +
		    		  	   "VALUES('Reykjavik Excursions', '5805400','main@re.is')";
		      stmt.executeUpdate(sql);
             */

            String sql = "INSERT INTO Daytrips(NAME,COMPANY,PRICE,DESCR,KEYWORDS,CATEGORY,HOTELPICKUP) " +
                    "VALUES('Snorkeling in Silfra', 'Reykjavik Excursions',46900, 'Snorkeling in Iceland is an activity that everyone who has learnt to swim can enjoy.',"+
                    "'Thingvellir - Geysir - Gullfoss - Super jeep - Snowmobiling', 'Adventure', 'No Pickup');";
            stmt.executeUpdate(sql);


            sql = "INSERT INTO indivDaytrips(ID,STARTTIME,ENDTIME,DAYTRIP,NUMSEATSAVAIL) " +
                    "VALUES(0102, '2016-04-20 09:00:00.000', '2016-04-20 19:00:00.000', 'Super Jeep & Snowmobiling', 20);";
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
    
    public static ResultSet execute(String sql){
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ResultSet getTable(String table){
        String sql = "SELECT * FROM "+table;
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ResultSet deleteEntry(String table, String cond){
    	String sql = "DELETE FROM "+table+" WHERE "+cond+";";
    	try {
    		return stmt.executeQuery(sql);
    	}catch (SQLException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    public static boolean matchDB(String name, String table, String column){
        String sql = "SELECT " +column+" FROM "+table+" WHERE "+column+"="+name;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void insert(String sql){
        try{
            stmt.executeUpdate(sql);
        } catch (SQLException e){
            System.out.println("SQL error");
        } catch (NullPointerException e){
            System.out.println("Database hasn't been opened");
        }
    }

    public static void connectToDatabase(){
        c = null;
        stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Database.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");		
        } catch ( Exception e ) {      
        }
    }


    public static void closeDatabase(){
        try {
            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.out.println("Database closed");
        }
        System.out.println("Table created successfully"); 
    }
}