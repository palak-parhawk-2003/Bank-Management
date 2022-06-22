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
        if(upass.length()<5){
            System.out.println("Invalid Password");
            return;
        }

        System.out.println(uname+" you are Registered Successfully");

        System.out.println("Enter the Username");
        String lname = sc.nextLine();
        System.out.println("Enter the Password");
        String lpass = sc.nextLine();

        if(uname.equals(lname) && upass.equals(lpass)){
            System.out.println("Welcome "+lname+" you have Logged-in Successfully");
        }
        else{
            System.out.println("Username or password Mismatch");
        }
    }
}