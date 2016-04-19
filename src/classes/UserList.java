package classes;
import java.sql.*;
import java.util.*;

public class UserList {
    
    public static void addUser(String ID, String h, String s, String n, String mail){
        Database.connectToDatabase();
        if(Database.matchDB(ID, "USERS", "ID")){
        	System.out.println("user already exists");
        	Database.closeDatabase();
        	return;
        }
        String sql ="Insert into users values("+ID+",'"+n+"','"+s+"','"+h+"','"+mail+"');";
        Database.insert(sql);
        Database.closeDatabase();
    }
    
    public static User pullUser(String ID){
    	Database.connectToDatabase();
        ResultSet rs = Database.execute("SELECT * FROM USERS WHERE ID='"+ID+"';");
        try {
            rs.next();
            String nafn = rs.getString(2);
            String town = rs.getString(3);
            String hotel = rs.getString(4);
            String email = rs.getString(5);
            Database.closeDatabase();
            return new User(ID, hotel, town, nafn, email);
        } catch (SQLException e) {
            e.printStackTrace();
            Database.closeDatabase();
            return null;
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("�etta er userInfo Klasinn");
    }
}
