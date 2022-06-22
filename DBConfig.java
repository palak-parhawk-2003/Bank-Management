import java.sql.*;
import java.util.*;
public class DBConfig {
    public Connection connection()
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","");
            con.setAutoCommit(false);
            return con;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return con;
        }
    }
    public static void main(String[] args) {
        //testing
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","");
            System.out.println(con.toString());
            con.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
