package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginCheck {
    static DatabaseHandler conn = new DatabaseHandler();

    public void Login(String email, String password) {
        cekCustomer(email, password);
    }

    public void cekCustomer(String email, String password) {
        String emailLogin = "";
        String pass = "";
        int id = 0;
        try {
            conn.connect();
            String query = "SELECT * FROM customer where email='" + email + "' AND password='" + password + "'";

            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emailLogin = rs.getString("email");
                pass = rs.getString("password");
                id = rs.getInt("cust_id");

                if (emailLogin.equals(email) && pass.equals(password)) {
                    LoginSingleton.getInstance().setUser(id, 0);
                    JOptionPane.showMessageDialog(null, "Welcome Customer !");
                } else if (emailLogin.equals(email) && (!pass.equals(password))) {
                    JOptionPane.showMessageDialog(null, "Password salah.");
                }

            }

            if (LoginSingleton.getInstance().getID() == 0) {
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
        int id = 0;

        try {
            conn.connect();
            String query = "SELECT * FROM seller where email='" + email + "' AND password='" + password + "'";

            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emailLogin = rs.getString("email");
                pass = rs.getString("password");
                id = rs.getInt("seller_id");

                if (emailLogin.equals(email) && pass.equals(password)) {
                    LoginSingleton.getInstance().setUser(id, 1);
                    JOptionPane.showMessageDialog(null, "Welcome Seller!");
                    new EditedCart();
                } else if (emailLogin.equals(email) && (!pass.equals(password))) {
                    JOptionPane.showMessageDialog(null, "Cek password nya lagi.");
                }
            }
            if (LoginSingleton.getInstance().getID() == 0) {
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
        int id = 0;

        try {
            conn.connect();
            String query = "SELECT * FROM admin where email='" + email + "' AND password='" + password + "'";

            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                emailLogin = rs.getString("email");
                pass = rs.getString("password");
                id = rs.getInt("admin_id");

                if (emailLogin.equals(email) && pass.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Welcome Admin!");
                    LoginSingleton.getInstance().setUser(id, 2);
                    new EditedCart();
                } else if (emailLogin.equals(email) && (!pass.equals(password))) {
                    JOptionPane.showMessageDialog(null, "Cek password nya lagi.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login gagal. Cek lagi email atau password nya.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
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