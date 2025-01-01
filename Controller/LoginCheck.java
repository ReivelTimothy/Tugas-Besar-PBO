package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Models.Classess.User;
import Models.Classess.UserCustomer;
import Models.Classess.UserSeller;
import Models.Enumeration.Membership;
import Models.Classess.UserAdmin;

public class LoginCheck {
    private static LoginCheck instance;
    private User userLogin;

    static DatabaseHandler conn = new DatabaseHandler();

    public LoginCheck() {
        this.userLogin = null;
    }

    public static LoginCheck getInstance() {
        if (instance == null) {
            instance = new LoginCheck();
        }
        return instance;
    }

    public void Login(String email, String password) {

        cekCustomer(email, password);
    }

    public void cekCustomer(String email, String password) {
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
                int id = rs.getInt("cust_id");
                String name = rs.getString("cust_name");
                String phone = rs.getString("phoneNum");
                String cardNum = rs.getString("cardNumber");
                Membership membership = Membership.valueOf(rs.getString("Membership"));
                double balance = rs.getDouble("Balance");
                System.out.println("Email: " + email + ", Password: " + password);

                userLogin = new UserCustomer(id, name, password, phone, emailLogin,
                        membership, cardNum, balance, null);
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
                String id = rs.getString("seller_id");
                String name = rs.getString("seller_name");
                String phone = rs.getString("phone_num");
                // userLogin = new UserSeller(id, name, password, phone, emailLogin);
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