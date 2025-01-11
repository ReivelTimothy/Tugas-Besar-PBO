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
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Email atau password salah !");
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

    public void cekSeller(String email, String password) {
        String emailLogin = "";
        String pass = "";
        int id = 0;
        System.out.println("haha");

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
                    break;
                } else if (!emailLogin.equals(email) && (!pass.equals(password))) {
                    JOptionPane.showMessageDialog(null, "Email atau password salah !");
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

    public void cekAdmin(String email, String password) {
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
                    break;
                } else if (emailLogin.equals(email) && (!pass.equals(password))) {
                    JOptionPane.showMessageDialog(null, "Email atau password salah !");
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