import java.sql.*;
import java.util.*;
public class Withdraw {
    public boolean withdraws(UserModel user,double withdraw) {
        Connection connection = new DBConfig().connection();
        System.out.println("Hello");

        if (connection!=null) {
            try {
                //shai hai
                PreparedStatement statement = connection.prepareStatement("UPDATE `bank` SET `balance` = balance - ? WHERE `acc_no` = ?");
                statement.setDouble(1, withdraw);
                statement.setInt(2, user.getId());
                statement.executeUpdate();

                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO `transaction`( `sender`, `reciver`, `amount`, `descripton`) VALUES (?,?,?,?)");                
                statement2.setInt(1, user.getId());
                statement2.setInt(2, user.getId());
                statement2.setDouble(3, withdraw);
                statement2.setString(4, "self withdraw");
                statement2.executeUpdate();
                user.setBalance(user.getBalance() - withdraw);
                connection.commit();
                connection.close();
                return true;
                

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                return false;

            }
        } else {
            System.out.println("Connection not establised!!!");
            return false;
            
        }
    }
}
