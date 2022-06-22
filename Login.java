import java.sql.*;
import java.util.*;
import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Username");
        String uname = sc.nextLine();

        System.out.println("Enter the Password");
        String upass = sc.nextLine();
        
        UserModel user = new BackendLogin().login(uname, upass);

        if (user!=null) {
            System.out.println("Hi! "+user.getName()+" you have Successfully login");
        } else {
            System.out.println("Error in login");
        }
    }
}