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
                in.nextLine();
                String name = in.nextLine();
                String sql = "UPDATE `bank` SET `name` = ? WHERE `acc_no`=?";
                Connection con = new DBConfig().connection();
                if (con != null) {
                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setString(1, name);
                        statement.setInt(2, model.getId());
                        statement.executeUpdate();
                        model.setName(name);
                        con.commit();
                        con.close();
                    } catch (Exception e) {
                        //TODO: handle exception
                        try {
                            con.rollback();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
            if (n==2) {
                System.out.println("Your Phone number: "+model.getPhoneNo());
                System.out.println("Enter new Phone number: ");
                in.nextLine();
                String Phoneno = in.nextLine();
                String sql = "UPDATE `bank` SET `phone_number` = ? WHERE `acc_no`=?";
                Connection con = new DBConfig().connection();
                if (con != null) {
                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setString(1, Phoneno);
                        statement.setInt(2, model.getId());
                        statement.executeUpdate();
                        model.setPhoneNo(Phoneno);
                        con.commit();
                        con.close();
                    } catch (Exception e) {
                        //TODO: handle exception
                        try {
                            con.rollback();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
            if (n==3) {
                System.out.println("Your Email: "+model.getEmail());
                System.out.println("Enter new Email: ");
                in.nextLine();
                String Email = in.nextLine();
                String sql = "UPDATE `bank` SET `email` = ? WHERE `acc_no`=?";
                Connection con = new DBConfig().connection();
                if (con != null) {
                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setString(1, Email);
                        statement.setInt(2, model.getId());
                        statement.executeUpdate();
                        model.setEmail(Email);
                        con.commit();
                        con.close();
                    } catch (Exception e) {
                        //TODO: handle exception
                        try {
                            con.rollback();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
            if (n==4) {
                System.out.println("Your Address: "+model.getAddress());
                System.out.println("Enter new Address: ");
                in.nextLine();
                String Address = in.nextLine();
                String sql = "UPDATE `bank` SET `address` = ? WHERE `acc_no`=?";
                Connection con = new DBConfig().connection();
                if (con != null) {
                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setString(1, Address);
                        statement.setInt(2, model.getId());
                        statement.executeUpdate();
                        model.setAddress(Address);;
                        con.commit();
                        con.close();
                    } catch (Exception e) {
                        //TODO: handle exception
                        try {
                            con.rollback();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
            if (n==5) {
                System.out.println("Your Password: "+model.getPassword());
                System.out.println("Enter new Password: ");
                in.nextLine();
                String Pass = in.nextLine();
                String sql = "UPDATE `bank` SET `password` = ? WHERE `acc_no`=?";
                Connection con = new DBConfig().connection();
                if (con != null) {
                    try {
                        PreparedStatement statement = con.prepareStatement(sql);
                        statement.setString(1, Pass);
                        statement.setInt(2, model.getId());
                        statement.executeUpdate();
                        model.setPassowrd(Pass);
                        con.commit();
                        con.close();
                    } catch (Exception e) {
                        //TODO: handle exception
                        try {
                            con.rollback();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
            if (n==6) {
                break;
            }
    }
}
public static void main(String[] args) {
    
}
}