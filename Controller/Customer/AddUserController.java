package Controller.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controller.DatabaseHandler;

public class AddUserController {
    static DatabaseHandler conn = new DatabaseHandler();

    public static boolean addUser(String role, String username, String password, String email, String phoneNum, String CardNum) { //tambahin para baru
    String query = "";

    role = role.toUpperCase();

    if (role.equals("SELLER")) {
        query = "INSERT INTO seller (seller_name, password, email, phoneNum) VALUES (?, ?, ?, ?)";
    } else if (role.equals("CUSTOMER")) {
        query = "INSERT INTO customer (cust_name, password, email, phoneNum, cardNumber) VALUES (?, ?, ?, ?, ?)";
    } else {
        JOptionPane.showMessageDialog(null, "Role salah", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    try {
        conn.connect();
        PreparedStatement statement = conn.con.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, email);
        statement.setString(4, phoneNum);
        
        if (role.equalsIgnoreCase("CUSTOMER")) {
            statement.setString(5, CardNum);
        }

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
