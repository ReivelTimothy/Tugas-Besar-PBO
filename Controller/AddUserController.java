package Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AddUserController {
    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean addUser(String role, String username, String password, String email, String phoneNum) {
    String query = "";

    role = role.toUpperCase();

    if (role.equals("SELLER")) {
        query = "INSERT INTO seller (seller_name, password, email, phoneNum) VALUES (?, ?, ?, ?)";
    } else if (role.equals("CUSTOMER")) {
        query = "INSERT INTO customer (cust_name, password, email, phoneNum) VALUES (?, ?, ?, ?)";
    } else {
        return false;
    }

    try {
        conn.connect();
        PreparedStatement statement = conn.con.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, email);
        statement.setString(4, phoneNum);

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    } finally {
        conn.disconnect();
    }
}

}
