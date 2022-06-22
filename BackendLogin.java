import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BackendLogin {
    public static void main(String[] args) {
        String id = 100+"";
        String pass = "Sub@2014";
        Connection con = new DBConfig().connection();
        if (con!=null) {
            try {
                PreparedStatement statement = con.prepareStatement("SELECT * FROM bank WHERE acc_no=?");
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                UserModel model = new UserModel(resultSet.getInt("acc_no"),resultSet.getString("name"),resultSet.getString(3),resultSet.getString(4), resultSet.getString(5), resultSet.getString(7), resultSet.getDouble(6));
                if (model.getPassword().equals(pass)) {
                  System.out.println("You have logged in successfully "+model.getName());  
                } else {
                    System.out.println("You haven't logged in successfully ");  
                    
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            
        }

    }
}
