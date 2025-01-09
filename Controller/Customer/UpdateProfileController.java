package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Controller.DatabaseHandler;
import Controller.LoginSingleton;

public class UpdateProfileController {

    public void updateUserInDatabase(String newUsername, String newPassword, String newPhone, String newEmail) {
        DatabaseHandler conn = new DatabaseHandler();

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
                System.out.println("User profile updated successfully.");
            } else {
                System.out.println("Failed to update profile.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
    }
}
