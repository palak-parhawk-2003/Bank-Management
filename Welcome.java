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
            while (true) {
                System.out.println("1) Login 2) Regiser 3) Exit");
            int n = in.nextInt();
            if (n==1) {
                new Login().login();
            }else if (n==2) {
                boolean status =new Register().registerUser();
                if (status) {
                    new Login().login(); 
                }
            }else
            if (n==3) {
                System.out.println("Thank you to use our service!!!");
                System.exit(0);
            }
             else {
                System.out.println("Wrong input");
            }
            }
            
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
