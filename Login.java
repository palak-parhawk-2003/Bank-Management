import java.sql.*;
import java.util.*;
import java.util.Scanner;
public class Login {
    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Username");
        String uname = sc.nextLine();

        System.out.println("Enter the Password");
        String upass = sc.nextLine();
        
        UserModel user = new BackendLogin().login(uname, upass);

        if (user!=null) {
            System.out.println("Hi! "+user.getName()+" you have Successfully login");
            new check().dashboard(user);
        } else {
            System.out.println("Error in login");
        }
    }
}