import java.sql.*;
import java.util.*;
public class Welcome {
    public static void main(String[] args) {
        //conntion checking
        Scanner in = new Scanner(System.in);
        Connection con = new DBConfig().connection();
        if(con!=null)
        {
            System.out.println("Welcome to My Bank ");
            System.out.println("1) Login 2) Regiser");
            int n = in.nextInt();
            

            
        }
        else
        {
            System.out.println("Not connected");
        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
