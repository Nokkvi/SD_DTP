package classes;
import java.sql.*;
import java.util.*;

public class UserList {
    
    public static void addUser(String ID, String hotel, String location, String name, String mail){
        Database.connectToDatabase();
        String sql ="Insert into users values("+ID+",'"+name+"','"+location+"','"+hotel+"','"+mail+"');";
        Database.insert(sql);
        Database.closeDatabase();
    }
    
    public static void main(String[] args) {
        System.out.println("�etta er userInfo Klasinn");
    }
}
