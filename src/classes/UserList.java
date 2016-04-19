package classes;
import java.sql.*;
import java.util.*;

public class UserList {
    
    public static void addUser(String ID, String h, String s, String n, String mail){
        Database.connectToDatabase();
        String sql ="Insert into users values("+ID+",'"+n+"','"+s+"','"+h+"','"+mail+"');";
        Database.insert(sql);
        Database.closeDatabase();
    }
    
    public static void main(String[] args) {
        System.out.println("�etta er userInfo Klasinn");
    }
}
