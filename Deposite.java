import java.sql.*;
import java.util.*;
public class Deposite {
    public boolean deposite(UserModel user,double deposite) {
        Connection connection = new DBConfig().connection();

        if (connection!=null) {
            try {
                PreparedStatement statement = connection.prepareStatement("UPDATE `bank` SET `balance` = balance + ? WHERE `acc_no` = ?");
                statement.setDouble(1, deposite);
                statement.setInt(2, user.getId());
                statement.executeUpdate();

                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO `transaction`( `sender`, `reciver`, `amount`, `descripton`) VALUES (?,?,?,?)");                
                statement2.setInt(1, user.getId());
                statement2.setInt(2, user.getId());
                statement2.setDouble(3, deposite);
                statement2.setString(4, "self deposite");
                statement2.executeUpdate();
                user.setBalance(user.getBalance() + deposite);
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
