import java.util.Scanner;

public class Register {
    public boolean registerUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name");
           String name = in.nextLine();
           System.out.println("Enter your phone number");
           String phone = in.nextLine();
           System.out.println("Enter your email");
           String email = in.nextLine();
           System.out.println("Enter your address");
           String address = in.nextLine();
           System.out.println("Enter your password");
           String password = in.nextLine();
           System.out.println("Enter your deposit balance");
           double balance = in.nextDouble();
           UserModel model = new UserModel(name, phone, email, address, password, balance);
           int userID = new Transaction().registerUser(model);
        //    System.out.println();
        if (userID!=-1) {
            System.out.println("Your account has been created and your account number is "+userID);
            return true;
        } else {
            System.out.println("Your account has not been created");
            return false;
            
        }
    }
    public static void main(String[] args) {
        Register reg = new Register();
        boolean create =reg.registerUser();        
        System.out.println(create);
    }
}
