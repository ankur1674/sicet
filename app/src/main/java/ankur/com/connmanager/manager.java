package ankur.com.connmanager;

import android.os.StrictMode;

import java.io.LineNumberInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankur on 10/2/2017.
 */

public class manager {

    public String[] getNames(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        List<String> listNames = new ArrayList<String>();

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.0.105:1433/sicet_project;instance=SQLEXPRESS;user=sicet;password=sicet123;");

            System.out.println("test");
            Statement sta = conn.createStatement();
            String Sql = "SELECT * FROM CSEB";

            ResultSet rs = sta.executeQuery(Sql);
            while (rs.next()) {
                listNames.add(rs.getString("Name"));
                System.out.println(rs.getString("Name"));
            }

            if(conn != null)
                conn.close();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return listNames.toArray(new String[0]);
    }

}
