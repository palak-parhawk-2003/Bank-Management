import java.sql.*;
import java.util.*;
public class check {
    public void dashboard(UserModel model) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome!!! "+model.getName());
        while (true) {
            System.out.println("1) Check Balance 2) Withdraw 3) Deposite 4) Edit Your Profile 5) Logout");
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
            if(n==5){
                model = null;
                System.out.println("You have Logged Out!!!");
                break;
            }
        }
    }
}
