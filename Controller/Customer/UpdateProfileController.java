package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class UpdateProfileController {
    static DatabaseHandler conn = new DatabaseHandler();

    public boolean updateUserInDatabase(String newUsername, String newPassword, String newPhone, String newEmail) {

        int cust_id = LoginSingleton.getInstance().getID();

        String query = "UPDATE customer SET cust_name = ?, password = ?, email = ?, phoneNum = ? WHERE cust_id = ?";

        try {
            conn.connect();
            PreparedStatement statement = conn.con.prepareStatement(query);
            
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, newEmail);
            statement.setString(4, newPhone);
            statement.setInt(5, cust_id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
        
    }
}
