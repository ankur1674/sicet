package ankur.com.connmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by ankur on 10/2/2017.
 */

public class manager {

    public void RunQuery(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;Database=master;Trusted_Connection=True");

            System.out.println("test");
            Statement sta = conn.createStatement();
            String Sql = "SELECT * FROM CSEB\n" +
                    "WHERE NAME LIKE '%GOPI'";
            ResultSet rs = sta.executeQuery(Sql);
            while (rs.next()) {
                System.out.println(rs.getString("RollNo"));
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
