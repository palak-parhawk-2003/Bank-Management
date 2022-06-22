import java.sql.*;
import java.util.*;
public class check {
    public void dashboard(UserModel model) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome!!! "+model.getName());
        while (true) {
            System.out.println("1) Check Balance 2) Withdraw 3) Deposite 4) Edit Your Profile 5) Transaction History 6) Logout");
            int n = in.nextInt();
            if (n==1) {
                System.out.println("Your balance is "+model.getBalance());
            }
            if (n==2) {
                System.out.println("Enter amount to be withdrawn: ");
                double withdraw = in.nextDouble();
                double amt = model.getBalance() - withdraw;
                if (amt<=500) {
                    System.out.println("Transaction is not possible!!! "+amt);
                }
                else{
                    boolean status = new Withdraw().withdraws(model, withdraw);
                    if (status) {
                        System.out.println("Transaction Successful!!!");
                    } else {
                        
                        System.out.println("Transaction Unsuccessful!!!");
                    }
                    System.out.println("Your current balance is: "+model.getBalance());
                }
            }
            if (n==3) {
                System.out.println("Enter amount to be deposited: ");
                Double deposite = in.nextDouble();
                double amount = model.getBalance() + deposite;
                // System.out.println("Transaction Successful!!!");
                System.out.println("Your current balance is: "+amount);
            }
            if (n==4) {
                
            }
            if (n==5) {
                String sql = "SELECT a.id,a.amount,a.descripton,a.created_at,b.name as sender_name, c.name as reciver_name FROM `transaction` a LEFT JOIN bank b ON b.acc_no = a.sender left JOIN bank c ON c.acc_no = a.reciver WHERE a.sender = ?";
                Connection con = new DBConfig().connection();
                if (con != null) {
                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setInt(1, model.getId());
                        ResultSet set = statement.executeQuery();
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("------   DATE    -------  ID  ----------         TO          -----------    AMOUNT        -----------     DESCRIPTION      ----------------------");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                        while (set.next()) {
                            System.out.println(set.getString(4)+"-------"+set.getString(1)+"-------"+set.getString(6)+"-------"+set.getString(2)+"-------"+set.getString(3)+"-------");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                        }
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                else
                {
                    System.out.println("Connection problem");
                }

            }
            if(n==6){
                model = null;
                System.out.println("You have Logged Out!!!");
                break;
            }
        }
    }
}
