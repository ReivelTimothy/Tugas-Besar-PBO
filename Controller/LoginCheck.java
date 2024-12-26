package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginCheck {

    static DatabaseHandler conn = new DatabaseHandler();

    public LoginCheck(String usn, String password) {
        cekUser(usn, password);
    }

    public static void cekUser(String username, String password) {
        String usernameLogin = "";
        String pass = "";

        try {
            conn.connect();
            // String query = "SELECT * FROM users where email='" + email + "' && password='" + password + "'";

            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                loginEmail = rs.getString("email");
                pass = rs.getString("password");
            }

            if (loginEmail.equals(email) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Welcome!");
            } else if (loginEmail.equals(email) && (!pass.equals(password))) {
                JOptionPane.showMessageDialog(null, "Cek password nya lagi.");
            } else if ((!loginEmail.equals(email)) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Cek email nya lagi.");
            } else {
                JOptionPane.showMessageDialog(null, "Login gagal. Cek lagi email atau password nya.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }
    }
}
