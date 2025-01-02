package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Classess.User;

public class UpdateProfileController {

    public void updateProfile(String newUsername, String newPassword, String newPhone, String newEmail) {
        LoginCheck loginCheck = LoginCheck.getInstance();
        User user = loginCheck.getUserLogin();

        if (!newUsername.equals(user.getName())) {
            user.setName(newUsername);
        }
        if (!newPassword.equals(user.getPassword())) {
            user.setPassword(newPassword);
        }
        if (!newPhone.equals(user.getNoTlp())) {
            user.setNoTlp(newPhone);
        }
        if (!newEmail.equals(user.getEmail())) {
            user.setEmail(newEmail);
        }

        updateUserInDatabase(user);
    }

    private void updateUserInDatabase(User user) {
        DatabaseHandler conn = new DatabaseHandler();
        String query = "UPDATE customer SET cust_name = ?, password = ?, email = ?, phoneNum = ? WHERE cust_id = ?";

        try {
            conn.connect();
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getNoTlp());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getID_karyawan());

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("User profile updated successfully.");
            } else {
                System.out.println("Failed to update profile.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
