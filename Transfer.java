import java.sql.*;
import java.util.*;

public class Transfer {
    public void transfer(UserModel model) {
        Scanner in = new Scanner(System.in);
        Connection con = new DBConfig().connection();
        System.out.println("Welcome!!! " + model.getName());
        if (con != null) {
            System.out.println("Your current balance is: " + model.getBalance());

            try {
                System.out.println("Enter account number of receiver: ");
                int r = in.nextInt();

                PreparedStatement statement = con.prepareStatement("SELECT * FROM `bank` WHERE `acc_no` = ?");
                statement.setDouble(1, r);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    System.out.println("Enter amount to be transfered: ");
                    double t = in.nextDouble();
                    double diff = model.getBalance() - t;
                    if (model.getBalance() <= 500 || model.getBalance() < t || diff <= 500) {
                        System.out.println("Sorry transaction is not possible!!!");
                    } else {
                        PreparedStatement statement1 = con
                                .prepareStatement("UPDATE `bank` SET `balance` = balance - ? WHERE `acc_no` = ?");
                        statement1.setDouble(1, t);
                        statement1.setDouble(2, model.getId());
                        statement1.executeUpdate();
                        PreparedStatement statement2 = con
                                .prepareStatement("UPDATE `bank` SET `balance` = balance + ? WHERE `acc_no` = ?");
                        statement2.setDouble(1, t);
                        statement2.setDouble(2, r);
                        statement2.executeUpdate();
                        con.commit();
                        con.close();
                        System.out.println("Done!!!");
                    }
                } else {
                    System.out.println("Please enter a valid Account number!!!");
                    con.rollback();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                try {
                    con.rollback();
                } catch (Exception e1) {
                    // TODO: handle exception
                }
            }

        } else {
            System.out.println("Not connected");
        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserModel model = new UserModel(100, "name", "phoneno", "email", "address", "password", 5000);
        new Transfer().transfer(model);
    }
}
