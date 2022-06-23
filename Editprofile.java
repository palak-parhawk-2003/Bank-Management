import java.sql.*;
import java.util.*;
public class Editprofile {
    public void edit(UserModel model) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome!!! "+model.getName());
        while (true) {
            System.out.println("1) Edit Name 2) Edit PhoneNo 3) Edit Email 4) Edit Address 5) Edit Password 6) Exit");
            int n = in.nextInt();
            if (n==1) {
                System.out.println("Your Name: "+model.getName());
                System.out.println("Enter new Name: ");
                String name = in.nextLine();
                String sql = "UPDATE `bank` SET `name` = ? WHERE `acc_no`=?";
                Connection con = new DBConfig().connection();
                if (con != null) {
                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setString(1, name);
                        statement.setInt(2, model.getId());
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                }
            }
            if (n==2) {
                
            }
            if (n==3) {
                
            }
            if (n==4) {
                
            }
            if (n==5) {
                
            }
            if (n==6) {
                model = null;
                System.out.println(" ");
                break;
            }
    }
}
}