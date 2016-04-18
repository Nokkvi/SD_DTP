package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyList {

    public static String[] getCompanyDetails(String name){
        ResultSet rs = Database.execute("SELECT * FROM company WHERE name='"+name+"';"); //Nafn-Sími-email
        try {
            rs.next();
            String nafn = rs.getString(1);
            String simi = rs.getString(2);
            String email = rs.getString(3);
            return new String[]{nafn,simi,email};
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
