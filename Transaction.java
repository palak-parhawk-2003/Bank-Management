import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Transaction {
    public int registerUser(UserModel model)
    {
        Connection con = new DBConfig().connection();
        if(con!=null)
        {
           try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO bank(name, phone_number, email, address, balance, password) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getName());
            statement.setString(2, model.getPhoneNo());
            statement.setString(3, model.getEmail());
            statement.setString(4, model.getAddress());
            statement.setDouble(5, model.getBalance());
            statement.setString(6, model.getPassword());
            int i = statement.executeUpdate();
            // System.out.println(statement.toString());
            ResultSet rs = statement.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
                System.out.println("Inserted record's ID: " + generatedKey);

            
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            if (i > 0) {
                return generatedKey;
            } else {
                return -1;
                
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }

            
        }
        else
        {
            System.out.println("Not connected");
            return -1;
        }
    }
}
