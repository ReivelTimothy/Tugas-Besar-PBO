package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginCheck {

    static DatabaseHandler conn = new DatabaseHandler();

    public LoginCheck(String email, String password) {
        cekCustomer(email, password);
    }

    public static void cekCustomer(String email, String password) {
        String emailLogin = "";
        String pass = "";

        try {
            conn.connect();
            String query = "SELECT * FROM customer where email='" + email + "' AND password='" + password + "'";

            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emailLogin = rs.getString("email");
                pass = rs.getString("password");
            }

            if (emailLogin.equals(email) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Welcome Customer !");
            } else if (emailLogin.equals(email) && (!pass.equals(password))) {
                JOptionPane.showMessageDialog(null, "Password salah.");
            } else if ((!emailLogin.equals(email)) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "email salah.");
            } else {
                cekSeller(email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }
    }

    public static void cekSeller(String email, String password) {
        String emailLogin = "";
        String pass = "";

        try {
            conn.connect();
            String query = "SELECT * FROM seller where email='" + email + "' AND password='" + password + "'";

            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emailLogin = rs.getString("email");
                pass = rs.getString("password");
            }

            if (emailLogin.equals(email) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Welcome Seller!");
            } else if (emailLogin.equals(email) && (!pass.equals(password))) {
                JOptionPane.showMessageDialog(null, "Cek password nya lagi.");
            } else if ((!emailLogin.equals(email)) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Cek email nya lagi.");
            } else {
                cekAdmin(email, password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }
    }

    public static void cekAdmin(String email, String password) {
        String emailLogin = "";
        String pass = "";

        try {
            conn.connect();
            String query = "SELECT * FROM seller where email='" + email + "' AND password='" + password + "'";

            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emailLogin = rs.getString("email");
                pass = rs.getString("password");
            }

            if (emailLogin.equals(email) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Welcome Admin!");
            } else if (emailLogin.equals(email) && (!pass.equals(password))) {
                JOptionPane.showMessageDialog(null, "Cek password nya lagi.");
            } else if ((!emailLogin.equals(email)) && pass.equals(password)) {
                JOptionPane.showMessageDialog(null, "Cek email nya lagi.");
            } else {

                JOptionPane.showMessageDialog(null, "Login gagal. Cek lagi email atau password nya.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            conn.disconnect();
        }
    }

}